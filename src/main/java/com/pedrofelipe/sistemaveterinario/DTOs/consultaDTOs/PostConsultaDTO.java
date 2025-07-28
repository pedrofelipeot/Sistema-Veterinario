package com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostConsultaDTO {
    private String doenca;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
    private GetMedicoDTO medicoDTO;
    private GetAnimalDTO animalDTO;

}
