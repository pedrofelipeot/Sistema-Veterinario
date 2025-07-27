package com.pedrofelipe.sistemaveterinario.repository;

import com.pedrofelipe.sistemaveterinario.entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("""
    SELECT c FROM Consulta c
    WHERE LOWER(c.medico.nome) LIKE LOWER(CONCAT(:nomeMedico, '%'))
    OR LOWER(c.medico.nome) LIKE LOWER(CONCAT('% ', :nomeMedico, '%'))
    """)
    List<Consulta> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

    @Query("""
    SELECT c FROM Consulta c
    WHERE LOWER(c.animal.nome) LIKE LOWER(CONCAT(:nomeAnimal, '%'))
    OR LOWER(c.animal.nome) LIKE LOWER(CONCAT('% ', :nomeAnimal, '%'))
    """)
    List<Consulta> findByNomeAnimal(@Param("nomeAnimal") String nomeAnimal);
}