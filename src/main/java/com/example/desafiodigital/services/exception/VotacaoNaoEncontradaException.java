package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class VotacaoNaoEncontradaException extends ExceptionPadrao{

    public VotacaoNaoEncontradaException(){
        super("Votacao nao encontrada", HttpStatus.NOT_FOUND);
    }

}
