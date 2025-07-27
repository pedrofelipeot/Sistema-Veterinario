package com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;

import java.time.LocalDateTime;

public class PutConsultaDTO {
    private String doenca;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private GetMedicoDTO medicoDTO;
    private GetAnimalDTO animalDTO;
}
