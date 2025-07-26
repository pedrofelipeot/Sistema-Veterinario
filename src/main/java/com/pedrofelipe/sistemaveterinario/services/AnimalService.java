package com.pedrofelipe.sistemaveterinario.services;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
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
                new RuntimeException("Erro ao carregar animal"));
       return animalMapper.getAnimalId(animal);
    }

    public List<GetAnimalDTO> listarPorNome(String nome){
        List<Animal> animal = animalRepository.findByNome(nome);
        return animalMapper.getAnimal(animal);
    }
}
