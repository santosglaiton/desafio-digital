package com.example.desafiodigital.service;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.repositories.PautaRepository;
import com.example.desafiodigital.services.PautaService;
import com.example.desafiodigital.services.exception.IllegalArgumentException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PautaServiceTest {

    @Mock
    private PautaRepository pautaRepository;

    @InjectMocks
    private PautaService pautaService;

    @Test
    public void testaSalvarComSucesso(){
        Pauta pauta = new Pauta();
        pauta.setDescricao("Teste");
        pautaService.save(pauta);
        verify(pautaRepository, times(1)).save(pauta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testaSalvarSemDescricao(){
        Pauta pauta = new Pauta();
        pautaService.save(pauta);
    }

    @Test
    public void testaFindById(){
        Pauta pauta = new Pauta();
        pauta.setId(1);
        pauta.setDescricao("teste");
        pautaService.save(pauta);
        Mockito.when(pautaRepository.findById(1)).thenReturn(Optional.of(pauta));
        pautaService.findById(1);
        verify(pautaRepository, times(1)).findById(pauta.getId());
    }

}
