package com.pedrofelipe.sistemaveterinario.repository;

import com.pedrofelipe.sistemaveterinario.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository <Animal, Long> {
    List<Animal> findByNome(String nome);
}
