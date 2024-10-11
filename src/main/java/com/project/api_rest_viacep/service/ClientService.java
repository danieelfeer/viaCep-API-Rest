package com.project.api_rest_viacep.service;

import com.project.api_rest_viacep.model.Client;

/**
 * Interface that defines the <b>Strategy</b> pattern in the client domain. This allows for multiple implementations of the same interface if needed.
 *
 * @author danieelfeer
 */

public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void post(Client client);

    void update(Long id, Client client);

    void delete(Long id);

}
