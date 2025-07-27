package com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs;

import lombok.Data;

@Data
public class GetMedicoDTO {
    private long id;
    private String nome;
    private long idade;
    private String crmv;
}
