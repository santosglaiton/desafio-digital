package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.repositories.PautaRepository;
import com.example.desafiodigital.repositories.VotacaoRepository;
import com.example.desafiodigital.repositories.VotoRepository;
import org.hibernate.ObjectNotFoundException;
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

    public void verificaSeVotoJaExiste(Voto voto){
        Optional<Voto> votoPorCpfEPauta = votoRepository.findByCpf(voto.getCpf());
        if(votoPorCpfEPauta.isPresent())
            throw new IllegalArgumentException("Voto ja existe");
    }

    public Votacao criarVotacao(Integer id, Votacao votacao){
        Optional<Pauta> findById = pautaRepository.findById(id);
        if (!findById.isPresent()){
            throw new ObjectNotFoundException(id, "Pauta nao encontrada");
        }
        votacao.setPauta(findById.get());
        return salvaDataEValidade(votacao);
    }

    public Votacao salvaDataEValidade(Votacao votacao){
        if (votacao.getInicioVotacao() == null){
            votacao.setInicioVotacao(LocalDateTime.now());
        }
        if (votacao.getValidadeVotacao() == null){
            votacao.setValidadeVotacao(1L);
        }
        return votacaoRepository.save(votacao);
    }

    public List<Voto> findAll(){
        return votoRepository.findAll();
    }

    public Votacao findById(Integer id){
        Optional<Votacao> findById = votacaoRepository.findById(id);
        if (!findById.isPresent()){
            throw new ObjectNotFoundException(id, "Votacao nao encontrada");
        }
        return findById.get();
    }

}
