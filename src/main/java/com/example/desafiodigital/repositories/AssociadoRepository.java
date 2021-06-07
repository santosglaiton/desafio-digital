package com.example.desafiodigital.repositories;

import com.example.desafiodigital.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {
}
