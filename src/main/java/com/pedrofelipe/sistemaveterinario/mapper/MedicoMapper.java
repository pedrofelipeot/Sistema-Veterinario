package com.pedrofelipe.sistemaveterinario.mapper;

import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PostMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PutMedicoDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MedicoMapper {
    public abstract List<GetMedicoDTO> getMedico(List<Medico> medico);
    public abstract GetMedicoDTO getMedicoId(Medico medico);
    public abstract void putMedico(PutMedicoDTO putMedicoDTO, @MappingTarget Medico medico);
    public abstract Medico postMedico(PostMedicoDTO postMedicoDTO);
}
