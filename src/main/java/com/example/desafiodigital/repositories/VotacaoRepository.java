package com.example.desafiodigital.repositories;

import com.example.desafiodigital.domain.Votacao;
import com.example.desafiodigital.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VotacaoRepository extends JpaRepository<Votacao, Integer> {

}
