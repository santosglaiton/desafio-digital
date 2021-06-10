package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.repositories.VotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VotoService {

    private VotoRepository votoRepository;
    private VotacaoService votacaoService;

    public VotoService(VotoRepository votoRepository, VotacaoService votacaoService){
        this.votoRepository = votoRepository;
        this.votacaoService = votacaoService;
    }

    public void verificaTempoDeVotacao(Votacao votacao, Voto voto) throws Exception {
        LocalDateTime dataLimiteVotacao = votacao.getInicioVotacao().plusMinutes(votacao.getValidadeVotacao());
        if (LocalDateTime.now().isAfter(dataLimiteVotacao)){
            throw new Exception("Data limite excedida");
        }
    }

    public Voto save(Votacao votacao, Voto voto) throws Exception {
        verificaTempoDeVotacao(votacao, voto);
        return votoRepository.save(voto);
    }

}
