package com.example.desafiodigital.repositories;

import com.example.desafiodigital.domain.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
