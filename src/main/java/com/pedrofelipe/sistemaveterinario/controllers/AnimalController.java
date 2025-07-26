package com.pedrofelipe.sistemaveterinario.controllers;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("animais")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<GetAnimalDTO>> listarAnimais(){
        return ResponseEntity.ok(animalService.listarAnimais());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<GetAnimalDTO> listarAnimalId(@PathVariable long id){
        return ResponseEntity.ok(animalService.listarPorId(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<GetAnimalDTO>> listarAnimalNome(@RequestParam String nome){
        return ResponseEntity.ok(animalService.listarPorNome(nome));
    }

}
