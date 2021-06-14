package com.example.desafiodigital.dto;

import com.example.desafiodigital.domain.Voto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VotoDto {

    private String cpf;
    private Boolean votoAssociado;

    public Voto transformaParaEntity(){
        return new Voto(cpf, votoAssociado);
    }

}
