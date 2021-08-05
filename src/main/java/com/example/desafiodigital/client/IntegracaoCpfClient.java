package com.example.desafiodigital.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${integracao.cpf}", name = "IntegracaoCpfController")
public interface IntegracaoCpfClient {

    @GetMapping(path = "/{cpf}")
    Response verificaCpf(@PathVariable("cpf") String cpf);

}
