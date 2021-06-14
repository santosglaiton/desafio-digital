package com.example.desafiodigital.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

private LocalDateTime timestamp;
private Integer status;
private String error;
private String message;

}
