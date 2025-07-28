package com.pedrofelipe.sistemaveterinario.mapper;

import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.GetConsultaDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.PostConsultaDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.PutConsultaDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring",uses = {AnimalMapper.class,MedicoMapper.class})
public abstract class ConsultaMapper {

    @Mapping(source = "medico", target = "medicoDTO")
    @Mapping(source = "animal", target = "animalDTO")
    public abstract GetConsultaDTO getConsultaId(Consulta consulta);
    public abstract List<GetConsultaDTO> getConsulta(List<Consulta> consultas);
    public abstract Consulta postConsulta(PostConsultaDTO postConsultaDTO);

    @Mappings({
            @Mapping(target = "doenca", source = "doenca"),
            @Mapping(target = "data", source = "data")
    })
    public abstract Consulta putConsulta(PutConsultaDTO putConsultaDTO, @MappingTarget Consulta consulta);
}