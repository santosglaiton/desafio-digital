package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.repositories.PautaRepository;
import com.example.desafiodigital.repositories.VotacaoRepository;
import com.example.desafiodigital.repositories.VotoRepository;
import com.example.desafiodigital.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotacaoService {

    private VotacaoRepository votacaoRepository;
    private VotoRepository votoRepository;
    private PautaRepository pautaRepository;

    public VotacaoService (VotacaoRepository votacaoRepository, VotoRepository  votoRepository, PautaRepository pautaRepository){
        this.votacaoRepository = votacaoRepository;
        this.votoRepository = votoRepository;
        this.pautaRepository = pautaRepository;
    }

    public Votacao criarVotacao(Integer id, Votacao votacao){
        Optional<Pauta> findById = pautaRepository.findById(id);
        if (!findById.isPresent()){
            throw new ObjectNotFoundException("Pauta nao encontrada");
        }else {
            votacao.setInicioVotacao(LocalDateTime.now());
            votacao.setPauta(findById.get());
            if (votacao.getValidadeVotacao() == null) {
                votacao.setValidadeVotacao(1L);
            }
            return votacaoRepository.save(votacao);
        }
    }

    public List<Voto> findAll(){
        return votoRepository.findAll();
    }

    public Votacao findById(Integer id){
        Optional<Votacao> findById = votacaoRepository.findById(id);
        if (!findById.isPresent()){
            throw new ObjectNotFoundException("Votacao nao encontrada");
        }
        return findById.get();
    }

    public Votacao findByIdAndPautaId(Integer idVotacao, Integer idPauta){
        Optional<Votacao> findByIdAndPautaId = votacaoRepository.findByIdAndPautaId(idVotacao, idPauta);
        if (!findByIdAndPautaId.isPresent()){
            throw new ObjectNotFoundException("Pauta ou Votacao nao encontrados");
        }
        return findByIdAndPautaId.get();
    }

}
