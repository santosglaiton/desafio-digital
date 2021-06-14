package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class SessaoExpiradaException extends RuntimeException{

    public SessaoExpiradaException (String message){
        super(message);
    }

    public SessaoExpiradaException (String message, Throwable cause){
        super(message, cause);
    }

}
