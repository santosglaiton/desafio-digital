package com.example.desafiodigital.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String cpf;

    @Column(name = "voto_associado")
    private Boolean votoAssociado;

    @ManyToOne
    private Pauta pauta;

    public Voto(String cpf, Boolean votoAssociado){
        this.cpf = cpf;
        this.votoAssociado = votoAssociado;
    }

}
