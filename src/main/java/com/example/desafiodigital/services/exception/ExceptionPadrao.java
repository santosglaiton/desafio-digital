package com.example.desafiodigital.services.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ExceptionPadrao extends RuntimeException{

    private String codigo;
    private HttpStatus status;

}
