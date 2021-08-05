package com.example.desafiodigital.service;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.repositories.PautaRepository;
import com.example.desafiodigital.repositories.VotacaoRepository;
import com.example.desafiodigital.services.PautaService;
import com.example.desafiodigital.services.VotacaoService;
import com.example.desafiodigital.services.exception.IllegalArgumentException;
import com.example.desafiodigital.services.exception.ObjectNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VotacaoServiceTest {

    @Mock
    private VotacaoRepository votacaoRepository;

    @Mock
    private PautaRepository pautaRepository;

    @InjectMocks
    private VotacaoService votacaoService;

    @Test()
    public void testaSalvarVotacaoComSucesso(){
        Votacao votacao = new Votacao();
        votacao.setValidadeVotacao(1L);
        Pauta pauta = new Pauta();
        pauta.setId(1);
        pauta.setDescricao("Teste");
        Mockito.when(pautaRepository.findById(1)).thenReturn(Optional.of(pauta));
        votacaoService.criarVotacao(1, votacao);
        verify(votacaoRepository, times(1)).save(votacao);
    }

    @Test
    public void testaSalvarVotacaoComErro(){
        Votacao votacao = new Votacao();
        votacao.setValidadeVotacao(10L);
        Pauta pauta = new Pauta();
        pauta.setId(1);
        Mockito.when(pautaRepository.findById(Mockito.any())).thenReturn(Optional.of(pauta));
        votacaoService.criarVotacao(2, votacao);
        
    }

}
