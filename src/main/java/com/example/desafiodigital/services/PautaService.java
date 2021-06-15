package com.example.desafiodigital.services;

import com.example.desafiodigital.domain.Pauta;
import com.example.desafiodigital.repositories.PautaRepository;
import com.example.desafiodigital.services.exception.IllegalArgumentException;
import com.example.desafiodigital.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    private PautaRepository pautaRepository;

    public PautaService(PautaRepository pautaRepository){
        this.pautaRepository = pautaRepository;
    }

    public Pauta save(Pauta pauta){
        if (pauta.getDescricao() != null){
            return pautaRepository.save(pauta);
        }
        throw new IllegalArgumentException("O campo descricao deve ser preenchido");
    }

    public List<Pauta> findAll(){
        return pautaRepository.findAll();
    }

    public Pauta findById(Integer id) {
        Optional<Pauta> findById = pautaRepository.findById(id);
        if (!findById.isPresent()) {
            throw new ObjectNotFoundException("Pauta nao encontrada");
        }
        return findById.get();
    }
}
