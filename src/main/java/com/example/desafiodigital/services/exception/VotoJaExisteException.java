package com.example.desafiodigital.services.exception;


public class VotoJaExisteException extends RuntimeException{

    public VotoJaExisteException (String message){
        super(message);
    }

    public VotoJaExisteException (String message, Throwable cause){
        super(message, cause);
    }


}
