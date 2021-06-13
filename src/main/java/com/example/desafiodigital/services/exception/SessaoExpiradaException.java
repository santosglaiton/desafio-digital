package com.example.desafiodigital.services.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class SessaoExpiradaException extends ExceptionPadrao{

    public SessaoExpiradaException(){
        super("Tempo de votacao da sessao expirou", HttpStatus.FORBIDDEN);
    }

}
