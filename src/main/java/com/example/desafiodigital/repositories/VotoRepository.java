package com.example.desafiodigital.repositories;

import com.example.desafiodigital.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Integer> {

    Optional<Voto> findByCpf(String cpf);

    Optional<Voto> findByCpfAndPautaId(String cpf, Integer id);

    Optional<List<Voto>> findByPautaId(Integer id);
}
