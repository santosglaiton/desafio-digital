package com.example.desafiodigital.repositories;

import com.example.desafiodigital.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
}
