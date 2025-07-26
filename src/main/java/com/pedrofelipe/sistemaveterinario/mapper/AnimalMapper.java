package com.pedrofelipe.sistemaveterinario.mapper;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PostAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.PutAnimalDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Animal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AnimalMapper {

    public abstract List<GetAnimalDTO> getAnimal(List<Animal> animal);
    public abstract GetAnimalDTO getAnimalId(Animal animal);
    public abstract Animal postAnimal(PostAnimalDTO postAnimalDTO);
    public abstract Animal putAnimal(PutAnimalDTO putAnimalDTO);

}
