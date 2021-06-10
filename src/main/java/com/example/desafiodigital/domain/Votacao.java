package com.example.desafiodigital.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Votacao implements Serializable {

    @Id
    private Long id;

    private LocalDateTime inicioVotacao;

    private Long validadeVotacao;

    @ManyToOne
    private Pauta pauta;

    @ManyToOne
    private Voto voto;

}
