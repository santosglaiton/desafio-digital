package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class VotoJaExisteException extends RuntimeException{

    public VotoJaExisteException (String message){
        super(message);
    }

    public VotoJaExisteException (String message, Throwable cause){
        super(message, cause);
    }


}
