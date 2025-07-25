package com.pedrofelipe.sistemaveterinario.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String especie;
    private String raca;
    private long idade;
    private char sexo;
    @OneToMany(mappedBy = "animal")
    private List<Consulta> consultas;
}
