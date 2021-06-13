package com.example.desafiodigital.services.exception;

import org.springframework.http.HttpStatus;

public class VotoJaExisteException extends ExceptionPadrao{

    public VotoJaExisteException(){
        super("Voto ja existe", HttpStatus.ALREADY_REPORTED);
    }


}
