package com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs;

import lombok.Data;

@Data
public class PutMedicoDTO {
    private String nome;
    private long idade;
    private String crmv;
}
