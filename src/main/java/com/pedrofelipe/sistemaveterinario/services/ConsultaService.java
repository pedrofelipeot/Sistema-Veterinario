package com.pedrofelipe.sistemaveterinario.services;

import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.GetConsultaDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Consulta;
import com.pedrofelipe.sistemaveterinario.mapper.ConsultaMapper;
import com.pedrofelipe.sistemaveterinario.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final ConsultaMapper consultaMapper;

    public List<GetConsultaDTO> listarConsultas(){
        List<Consulta> consulta = consultaRepository.findAll();
        return consultaMapper.getConsulta(consulta);
    }

    public GetConsultaDTO listarPorId(long id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Consulta não encontrada"));
        return consultaMapper.getConsultaId(consulta);
    }

    public List<GetConsultaDTO> listarConsultasMedico(String nome){
        List<Consulta> consulta = consultaRepository.findByNomeMedico(nome);
        return consultaMapper.getConsulta(consulta);
    }

    public List<GetConsultaDTO> listarConsultasAnimal(String nome){
        List<Consulta> consulta = consultaRepository.findByNomeAnimal(nome);
        return consultaMapper.getConsulta(consulta);
    }

}
