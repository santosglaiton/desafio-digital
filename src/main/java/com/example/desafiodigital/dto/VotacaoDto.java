package com.example.desafiodigital.dto;

import com.example.desafiodigital.domain.Votacao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class VotacaoDto implements Serializable {

    private Long validadeVotacao;

    public Votacao transformaParaEntity(){
        return new Votacao(validadeVotacao);
    }

}
