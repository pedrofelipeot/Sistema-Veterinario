package com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs;

import lombok.Data;

@Data
public class GetAnimalDTO {
    private long id;
    private String nome;
    private String especie;
    private String raca;
    private long idade;
    private char sexo;
}
