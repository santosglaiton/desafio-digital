package com.example.desafiodigital.controllers;

import com.example.desafiodigital.dto.ResultadoDto;
import com.example.desafiodigital.domain.Voto;
import com.example.desafiodigital.dto.VotoDto;
import com.example.desafiodigital.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    public VotoController(VotoService votoService){
        this.votoService = votoService;
    }

    @PostMapping("/pautas/{idPauta}/votacao/{idVotacao}/voto")
    public Voto voto(@PathVariable Integer idPauta, @PathVariable Integer idVotacao, @RequestBody VotoDto votoDto) {
        return votoService.save(idPauta, idVotacao, votoDto.transformaParaEntity());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoDto> resultadoVotacao(@PathVariable Integer id){
        ResultadoDto obj = votoService.getResultadoVotacao(id);
        return ResponseEntity.ok().body(obj);
    }

}
