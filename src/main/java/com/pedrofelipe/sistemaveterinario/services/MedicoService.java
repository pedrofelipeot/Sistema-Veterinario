package com.pedrofelipe.sistemaveterinario.services;

import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.GetMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PostMedicoDTO;
import com.pedrofelipe.sistemaveterinario.DTOs.medicoDTOs.PutMedicoDTO;
import com.pedrofelipe.sistemaveterinario.entidades.Medico;
import com.pedrofelipe.sistemaveterinario.mapper.MedicoMapper;
import com.pedrofelipe.sistemaveterinario.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public List<GetMedicoDTO> listarMedico(){
        List<Medico> medico = medicoRepository.findAll();
        return medicoMapper.getMedico(medico);
    }

    public GetMedicoDTO listarPorId(long id){
        Medico medico = medicoRepository.findById(id).
                orElseThrow(()->new RuntimeException("Erro ao procurar médido"));
        return medicoMapper.getMedicoId(medico);
    }

    public List<GetMedicoDTO> listarPorNome(String nome){
        List<Medico> medico = medicoRepository.findByNome(nome);
        return medicoMapper.getMedico(medico);
    }

    public GetMedicoDTO criarMedico(PostMedicoDTO postMedicoDTO){
        Medico medico = medicoMapper.postMedico(postMedicoDTO);
        medico = medicoRepository.save(medico);
        return medicoMapper.getMedicoId(medico);
    }

    public void atualizarMedico(long id, PutMedicoDTO putMedicoDTO){
       Medico medicoExistente = medicoRepository.findById(id).
               orElseThrow(() -> new RuntimeException("Medico não encontrado"));
       medicoMapper.putMedico(putMedicoDTO,medicoExistente);
       medicoRepository.save(medicoExistente);
    }

    public void deletarMedico(long id){
        Medico medicoExistente = medicoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Medico não encontrado"));
        medicoRepository.delete(medicoExistente);
    }
}
