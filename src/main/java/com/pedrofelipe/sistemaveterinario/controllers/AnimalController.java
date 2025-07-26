package com.pedrofelipe.sistemaveterinario.controllers;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PostAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PutAnimalDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Animal;
import com.pedrofelipe.sistemaveterinario.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<GetAnimalDTO>criarAnimal(@RequestBody PostAnimalDTO postAnimalDTO){
       GetAnimalDTO getAnimalDTO = animalService.criarAnimal(postAnimalDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(getAnimalDTO);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> atualizarAnimal(@PathVariable long id, @RequestBody PutAnimalDTO putAnimalDTO){
        animalService.atualizarAnimal(id, putAnimalDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Atualizado com sucesso!");
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<String> deletarAnimal(@PathVariable long id){
        animalService.deletarAnimal(id);
        return ResponseEntity.status(HttpStatus.OK).body("Animal deletado com sucesso");
    }


}
