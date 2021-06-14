package com.example.desafiodigital.controllers;

import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.dto.VotacaoDto;
import com.example.desafiodigital.services.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/votacao")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    public VotacaoController(VotacaoService votacaoService){
        this.votacaoService = votacaoService;
    }

    @PostMapping("/pauta/{id}/votacao")
    public ResponseEntity<Votacao> criaVotacao (@PathVariable Integer id, @RequestBody VotacaoDto votacaoDto){
        return ResponseEntity.ok().body(votacaoService.criarVotacao(id,votacaoDto.transformaParaEntity()));
    }

}
