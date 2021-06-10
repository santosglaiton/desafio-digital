package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.domain.VotacaoDto;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.repositories.VotoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VotoService {

    private VotoRepository votoRepository;
    private VotacaoService votacaoService;

    public VotoService(VotoRepository votoRepository, VotacaoService votacaoService){
        this.votoRepository = votoRepository;
        this.votacaoService = votacaoService;
    }

    //public void verificaTempoDeVotacao(Votacao votacao, Voto voto) throws Exception {
      //  LocalDateTime dataLimiteVotacao = votacao.getValidadeVotacao();
        //if (LocalDateTime.now().isAfter(dataLimiteVotacao.plusMinutes(votacao.getValidadeVotacao()))){
          //  throw new Exception("Data limite excedida");
        //}
    //}


    public void verificaTempoDeVotacao(Votacao votacao, Voto voto) throws Exception{
        LocalDateTime dataInicio = LocalDateTime.now();
        if(dataInicio.plusMinutes(votacao.getValidadeVotacao()).isAfter(LocalDateTime.now())){
            throw new Exception("Horario de votacao excedido");
        }
    }

    public Voto save(Votacao votacao, Voto voto) throws Exception {
        verificaTempoDeVotacao(votacao, voto);
        return votoRepository.save(voto);
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
