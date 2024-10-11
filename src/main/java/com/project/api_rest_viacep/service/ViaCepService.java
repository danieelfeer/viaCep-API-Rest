package com.project.api_rest_viacep.service;

import com.project.api_rest_viacep.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * HTTP Client, created via <b>OpenFeign</b>, for consuming the API of
 * <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author danieelfeer
 */

@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Address cepConsult(@PathVariable("cep") String cep);
}
