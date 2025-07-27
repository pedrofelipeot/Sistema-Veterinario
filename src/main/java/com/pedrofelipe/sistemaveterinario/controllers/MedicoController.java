package com.pedrofelipe.sistemaveterinario.controllers;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PostMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PutMedicoDTO;
import com.pedrofelipe.sistemaveterinario.services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("medicos")
public class MedicoController {
    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<GetMedicoDTO>> listarMedicos(){
        List<GetMedicoDTO> medico = medicoService.listarMedico();
        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetMedicoDTO> listarPorId(@PathVariable long id){
        GetMedicoDTO medico = medicoService.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<GetMedicoDTO>> listarPorNome(@RequestParam String nome){
        List<GetMedicoDTO> medico = medicoService.listarPorNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(medico);
    }

    @PostMapping
    public ResponseEntity<GetMedicoDTO> criarMedico(@RequestBody PostMedicoDTO postMedicoDTO){
        GetMedicoDTO medicoDTO = medicoService.criarMedico(postMedicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> atualizarMedico(@PathVariable long id, @RequestBody PutMedicoDTO putMedicoDTO){
        medicoService.atualizarMedico(id,putMedicoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletarMedico(@PathVariable long id){
        medicoService.deletarMedico(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }




}
