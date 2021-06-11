package com.example.desafiodigital.controllers;

import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.services.VotacaoService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/votacao")
public class VotacaoController {

    private VotacaoService votacaoService;

    public VotacaoController(VotacaoService votacaoService){
        this.votacaoService = votacaoService;
    }

    @PostMapping("/pauta/{id}/votacao")
    public Votacao criaVotacao (@PathVariable Integer id, @RequestBody Votacao votacao){
        return votacaoService.criarVotacao(id,votacao);
    }

}
