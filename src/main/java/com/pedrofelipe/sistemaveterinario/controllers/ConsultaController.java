package com.pedrofelipe.sistemaveterinario.controllers;

import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.GetConsultaDTO;
import com.pedrofelipe.sistemaveterinario.services.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<GetConsultaDTO>> listarConsultas(){
        List<GetConsultaDTO> consulta = consultaService.listarConsultas();
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetConsultaDTO> listarPorId(@PathVariable long id){
        GetConsultaDTO consulta = consultaService.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @GetMapping("/find/medico")
    public ResponseEntity<List<GetConsultaDTO>> listarConsultasMedico(@RequestParam String nome){
        List<GetConsultaDTO> consulta = consultaService.listarConsultasMedico(nome);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @GetMapping("/find/animal")
    public ResponseEntity<List<GetConsultaDTO>> listarConsultasAnimal(@RequestParam String nome){
        List<GetConsultaDTO> consulta = consultaService.listarConsultasAnimal(nome);
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

}
