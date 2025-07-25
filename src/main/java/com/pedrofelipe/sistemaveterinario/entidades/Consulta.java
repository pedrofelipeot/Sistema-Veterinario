package com.pedrofelipe.sistemaveterinario.entidades;

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
    private LocalDateTime data;
}
