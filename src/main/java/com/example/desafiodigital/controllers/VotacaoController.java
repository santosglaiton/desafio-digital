package com.example.desafiodigital.controllers;

import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.services.VotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/votacao")
public class VotacaoController {

    private VotacaoService votacaoService;

    public VotacaoController(VotacaoService votacaoService){
        this.votacaoService = votacaoService;
    }

    @PostMapping("/pauta/{idPauta}/votacao")
    public Votacao criaVotacao (@PathVariable Integer idPauta, @RequestBody Votacao votacao){
        return votacaoService.criarVotacao(idPauta,votacao);
    }

}
