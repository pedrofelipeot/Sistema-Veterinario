package com.pedrofelipe.sistemaveterinario.services;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PostAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PutAnimalDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Animal;
import com.pedrofelipe.sistemaveterinario.mapper.AnimalMapper;
import com.pedrofelipe.sistemaveterinario.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public List<GetAnimalDTO> listarAnimais(){
       List<Animal> animal = animalRepository.findAll();
       return animalMapper.getAnimal(animal);
    }

    public GetAnimalDTO listarPorId(long id){
       Animal animal = animalRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Animal não encontrado"));
       return animalMapper.getAnimalId(animal);
    }

    public List<GetAnimalDTO> listarPorNome(String nome){
        List<Animal> animal = animalRepository.findByNome(nome);
        return animalMapper.getAnimal(animal);
    }

    public GetAnimalDTO criarAnimal(PostAnimalDTO postAnimalDTO){
        Animal animal = animalMapper.postAnimal(postAnimalDTO);
        animal = animalRepository.save(animal);
        return animalMapper.getAnimalId(animal);
    }

    public Animal atualizarAnimal(long id, PutAnimalDTO putAnimalDTO){
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animalMapper.putAnimal(putAnimalDTO, animalExistente);
        return animalRepository.save(animalExistente);
    }

    public void deletarAnimal(long id){
        Animal animalExistente = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
        animalRepository.delete(animalExistente);
    }

}
