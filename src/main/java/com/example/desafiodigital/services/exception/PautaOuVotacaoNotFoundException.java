package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class PautaOuVotacaoNotFoundException extends ExceptionPadrao{

    public PautaOuVotacaoNotFoundException(){
        super("Pauta ou votacao nao encontrados", HttpStatus.NOT_FOUND);
    }

}
