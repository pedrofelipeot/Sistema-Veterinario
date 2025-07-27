package com.pedrofelipe.sistemaveterinario.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;
    @ManyToOne
    @JoinColumn (name = "id_medico")
    private Medico medico;
    private String doenca;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data;
}
