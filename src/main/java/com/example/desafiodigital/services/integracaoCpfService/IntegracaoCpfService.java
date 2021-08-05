package com.example.desafiodigital.services.integracaoCpfService;

import com.example.desafiodigital.client.IntegracaoCpfClient;
import com.example.desafiodigital.dto.integracaoCpf.IntegracaoCpfDto;
import com.example.desafiodigital.services.exception.ApiIntegracaoException;
import com.example.desafiodigital.services.exception.CpfInvalidoException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class IntegracaoCpfService {

    private IntegracaoCpfClient integracaoCpfClient;

    private ObjectMapper mapper;

    @Autowired
    public IntegracaoCpfService(IntegracaoCpfClient integracaoCpfClient, ObjectMapper mapper) {
        this.integracaoCpfClient = integracaoCpfClient;
        this.mapper = mapper;
    }

    //public IntegracaoCpfService(){}

    public String validaCpfPodeVotar(String cpf) {
            try {
                Response response = integracaoCpfClient.verificaCpf(cpf);
                if (response.status() == 404){
                    throw new ApiIntegracaoException("CPF invalido");
                }
                String bodyStr = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                IntegracaoCpfDto integracaoCpfDto = mapper.readValue(bodyStr, IntegracaoCpfDto.class);
                return integracaoCpfDto.getStatus();
            }catch (JsonMappingException e){
                throw new ApiIntegracaoException("");
            }catch (JsonProcessingException e){
                throw new ApiIntegracaoException("");
            }catch (IOException e){
                throw new ApiIntegracaoException("");
            }
    }
}
