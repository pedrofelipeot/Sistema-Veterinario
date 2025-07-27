package com.pedrofelipe.sistemaveterinario.repository;

import com.pedrofelipe.sistemaveterinario.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query("SELECT m FROM Medico m WHERE LOWER(m.nome) LIKE LOWER(CONCAT('% ', :nome, '%'))" +
            " OR LOWER(m.nome) LIKE LOWER(CONCAT(:nome, '%'))")
    List<Medico> findByNome(@Param("nome") String nome);

}
