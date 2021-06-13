package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.dto.VotacaoDto;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.repositories.VotacaoRepository;
import com.example.desafiodigital.repositories.VotoRepository;
import com.example.desafiodigital.services.exception.PautaNaoEncontradaException;
import com.example.desafiodigital.services.exception.SessaoExpiradaException;
import com.example.desafiodigital.services.exception.VotacaoNaoEncontradaException;
import com.example.desafiodigital.services.exception.VotoJaExisteException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    private VotoRepository votoRepository;
    private VotacaoService votacaoService;
    private VotacaoRepository votacaoRepository;

    public VotoService(VotoRepository votoRepository, VotacaoService votacaoService, VotacaoRepository votacaoRepository){
        this.votoRepository = votoRepository;
        this.votacaoService = votacaoService;
        this.votacaoRepository = votacaoRepository;
    }

    public void verificaTempoDeVotacao(Integer idVotacao){
        Votacao votacao = votacaoRepository.findById(idVotacao).get();
        LocalDateTime dataLimiteVotacao = votacao.getInicioVotacao();
        if (LocalDateTime.now().isAfter(dataLimiteVotacao.plusMinutes(votacao.getValidadeVotacao()))){
            throw new SessaoExpiradaException();
        }
    }


    public Voto save(Integer idVotacao, Integer idPauta, Voto voto) {
            Votacao votacao = votacaoService.findById(idVotacao);
            if (votacao.getId() == null){
                throw new VotacaoNaoEncontradaException();
            }else {
                voto.setPauta(votacao.getPauta());
                if (voto.getPauta().getId() == null) {
                    throw new PautaNaoEncontradaException();
                }else {
                    votacaoService.findByIdAndPautaId(idVotacao, idPauta);
                    verificaTempoDeVotacao(idVotacao);
                    verificaSeVotoJaExiste(voto);
                    return votoRepository.save(voto);
                }
            }
    }
    public void verificaSeVotoJaExiste(Voto voto) {
        Optional<Voto> votoPorCpfEPauta = votoRepository.findByCpfAndPautaId(voto.getCpf(), voto.getPauta().getId());
        if (votoPorCpfEPauta.isPresent()){
            throw new VotoJaExisteException();
        }
    }

    public VotacaoDto contadorVotos(Integer id){
        Optional<List<Voto>> votosPorPauta = votoRepository.findByPautaId(id);
        Pauta pauta = votosPorPauta.get().iterator().next().getPauta();
        Integer total = votosPorPauta.get().size();
        Integer totalSim = (int) votosPorPauta.get().stream().filter(voto -> Boolean.TRUE.equals(voto.getVotoAssociado())).count();
        Integer totalNao = total - totalSim;
        return VotacaoDto.builder().pauta(pauta).totalVotos(total).totalSim(totalSim).totalNao(totalNao).build();
    }

    public VotacaoDto getResultadoVotacao(Integer id){
        VotacaoDto votacaoDto = contadorVotos(id);
        return votacaoDto;
    }

}
