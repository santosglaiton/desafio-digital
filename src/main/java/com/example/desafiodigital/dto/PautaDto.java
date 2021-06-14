package com.example.desafiodigital.dto;

import com.example.desafiodigital.domain.Pauta;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PautaDto implements Serializable {

    private String descricao;

public PautaDto(Pauta obj){
    descricao = obj.getDescricao();
}

public Pauta transformaParaEntity(){
    return new Pauta(descricao);
}

}
