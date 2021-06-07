package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.repositories.PautaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    private Pauta pauta;
    private PautaRepository pautaRepository;

    public Pauta save(Pauta pauta){
        return pautaRepository.save(pauta);
    }

    public List<Pauta> findAll(){
        return pautaRepository.findAll();
    }

    public Pauta findById(Integer id){
        Optional<Pauta> findById = pautaRepository.findById(id);
        return findById.get();

    }

}
