package com.pedrofelipe.sistemaveterinario.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long idade;
    private String crmv;
    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

}
