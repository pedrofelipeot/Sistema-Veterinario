package com.pedrofelipe.sistemaveterinario.services;

import com.pedrofelipe.sistemaveterinario.DTOs.animalDTOs.GetAnimalDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.GetConsultaDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.PostConsultaDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.consultaDTOs.PutConsultaDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Animal;
import com.pedrofelipe.sistemaveterinario.entidades.Consulta;
import com.pedrofelipe.sistemaveterinario.entidades.Medico;
import com.pedrofelipe.sistemaveterinario.mapper.ConsultaMapper;
import com.pedrofelipe.sistemaveterinario.repository.AnimalRepository;
import com.pedrofelipe.sistemaveterinario.repository.ConsultaRepository;
import com.pedrofelipe.sistemaveterinario.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final AnimalRepository animalRepository;
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

    public GetConsultaDTO criarConsulta(PostConsultaDTO postConsultaDTO) {
        Medico medico = medicoRepository.findById(postConsultaDTO.getMedicoDTO().getId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));

        Animal animal = animalRepository.findById(postConsultaDTO.getAnimalDTO().getId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));

        Consulta consulta = consultaMapper.postConsulta(postConsultaDTO);
        consulta.setMedico(medico);
        consulta.setAnimal(animal);

        consulta = consultaRepository.save(consulta);
        return consultaMapper.getConsultaId(consulta);
    }

    public void atualizarConsulta(long id, PutConsultaDTO putConsultaDTO){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));

        consultaMapper.putConsulta(putConsultaDTO, consulta); // atualiza campos simples

        Medico medico = medicoRepository.findById(putConsultaDTO.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        consulta.setMedico(medico);

        Animal animal = animalRepository.findById(putConsultaDTO.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
        consulta.setAnimal(animal);

        consultaRepository.save(consulta); // salva alterações
    }

    public void deletarConta(long id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consultaRepository.delete(consulta);
    }



}
