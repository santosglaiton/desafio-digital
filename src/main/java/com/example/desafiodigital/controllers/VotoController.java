package com.example.desafiodigital.controllers;

import com.example.desafiodigital.dto.VotacaoDto;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.services.VotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/voto")
public class VotoController {

    private VotoService votoService;

    public VotoController(VotoService votoService){
        this.votoService = votoService;
    }

    @PostMapping("/pautas/{idPauta}/votacao/{idVotacao/voto}")
    public Voto voto(@PathVariable Integer idPauta, @PathVariable Integer idVotacao, @RequestBody Voto voto) throws Exception {
        return votoService.save(idPauta, idVotacao, voto);
    }

    //@GetMapping("/{id}")
    //public VotacaoDto resultadoVotacao(@PathVariable Integer id){
      //  return votoService.getResultadoVotacao(id);
    //}

    @GetMapping("/{id}")
    public ResponseEntity<VotacaoDto> resultadoVotacao(@PathVariable Integer id){
        return ResponseEntity.ok().body(votoService.getResultadoVotacao(id));
    }

}
