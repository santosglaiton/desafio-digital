package com.example.desafiodigital.controllers.exceptions;

import com.example.desafiodigital.services.exception.CpfInvalidoException;
import com.example.desafiodigital.services.exception.ObjectNotFoundException;
import com.example.desafiodigital.services.exception.SessaoExpiradaException;
import com.example.desafiodigital.services.exception.VotoJaExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(SessaoExpiradaException.class)
    public ResponseEntity<StandardError> sessaoExpirada(SessaoExpiradaException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.REQUEST_TIMEOUT.value(), "Session Time Out", e.getMessage());
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(error);
    }

    @ExceptionHandler(VotoJaExisteException.class)
    public ResponseEntity<StandardError> votoJaExiste(VotoJaExisteException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.FORBIDDEN.value(), "Voto already exists", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<StandardError> cpfComTamanhoInvalido(CpfInvalidoException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "CPF deve conter 11 digitos", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
