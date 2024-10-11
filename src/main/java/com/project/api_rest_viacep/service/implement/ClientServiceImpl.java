package com.project.api_rest_viacep.service.implement;

import com.project.api_rest_viacep.model.Address;
import com.project.api_rest_viacep.model.Client;
import com.project.api_rest_viacep.repository.AddressRepository;
import com.project.api_rest_viacep.repository.ClientRepository;
import com.project.api_rest_viacep.service.ClientService;
import com.project.api_rest_viacep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the <b>Strategy</b> {@link ClientService}, which can be
 * injected by Spring (via {@link Autowired}). Thus, since this class is a
 * {@link Service}, it will be treated as a <b>Singleton</b>.
 *
 * @author danieelfeer
 */
@Service
public class ClientServiceImpl implements ClientService {

    //Singleton: Injecting Spring components with @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    //Strategy: Implement the methods defined in the interface.
    //Facade: Abstract integrations with subsystems, providing a simple interface.

    @Override
    public Iterable<Client> findAll() {
        //Find all Clients.
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        //Find Client by ID.
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void post(Client client) {
        //Save Client.
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        //Find Client by ID if exists
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        //Delete by ID.
        clientRepository.deleteById(id);
    }

    private void saveClientWithCep(Client client){
        //Verify if the client address already exists (by cep).
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(()->{
            //If it doesn't exist, integrate with ViaCEP to persist the return.
           Address newAddress = viaCepService.cepConsult(cep);
           addressRepository.save(newAddress);
           return newAddress;
        });
        client.setAddress(address);
    }
}
