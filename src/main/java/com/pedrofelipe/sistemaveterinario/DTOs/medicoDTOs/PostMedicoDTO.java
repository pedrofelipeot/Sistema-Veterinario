package com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs;

import lombok.Data;

@Data
public class PostMedicoDTO {
    private String nome;
    private long idade;
    private String crmv;
}
