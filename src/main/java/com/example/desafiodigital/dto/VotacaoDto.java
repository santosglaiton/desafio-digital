package com.example.desafiodigital.dto;

import com.example.desafiodigital.domain.Pauta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotacaoDto implements Serializable {

    private Pauta pauta;
    private Integer totalVotos;
    private Integer totalSim;
    private Integer totalNao;

}
