package com.example.desafiodigital.controllers.exceptions;

import com.example.desafiodigital.services.exception.*;
import com.example.desafiodigital.services.exception.IllegalArgumentException;
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
        var error = new StandardError(LocalDateTime.now(), HttpStatus.FORBIDDEN.value(), "Voto ja existe", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<StandardError> cpfComTamanhoInvalido(CpfInvalidoException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "CPF deve conter 11 digitos", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> campoInvalido(IllegalArgumentException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.NO_CONTENT.value(), "O campo deve ser preenchido", e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
    }

    @ExceptionHandler(ApiIntegracaoException.class)
    public ResponseEntity<StandardError> cpfNaoPodeVotar(ApiIntegracaoException e, HttpServletRequest request){
        var error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "CPF invalido", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
