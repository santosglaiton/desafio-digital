package com.example.desafiodigital.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAssociado;

    @Column(unique = true)
    private String cpf;

}
