package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class PautaNaoEncontradaException extends ExceptionPadrao{

    public PautaNaoEncontradaException(){
        super("Pauta nao encontrada", HttpStatus.NOT_FOUND);
    }

}
