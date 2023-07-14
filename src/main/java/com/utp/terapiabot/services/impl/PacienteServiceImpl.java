package com.utp.terapiabot.services.impl;

import com.utp.terapiabot.entity.Paciente;
import com.utp.terapiabot.repository.PacienteRepository;
import com.utp.terapiabot.request.PacienteRequest;
import com.utp.terapiabot.response.PacienteResponse;
import com.utp.terapiabot.services.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public PacienteResponse guardarPaciente(PacienteRequest pacienteRequest) throws Exception {
        log.info("Inicio - PacienteServiceImpl::guardarPaciente - pacienteRequest: {}", pacienteRequest);
        Paciente pacienteFound = pacienteRepository.findByUsuario(pacienteRequest.getUsuario());
        PacienteResponse pacienteResponse;
        if (pacienteFound == null) {
            Paciente paciente = pacienteRepository.save(modelMapper.map(pacienteRequest, Paciente.class));
            pacienteResponse = modelMapper.map(paciente, PacienteResponse.class);
        } else {
            throw new Exception("Ya existe una cuenta con el mismo usuario");
        }
        log.info("Fin - PacienteServiceImpl::guardarPaciente - pacienteResponse: {}", pacienteResponse);
        return pacienteResponse;
    }

    @Override
    public PacienteResponse login(PacienteRequest pacienteRequest) throws Exception {
        log.info("Inicio - PacienteServiceImpl::login - pacienteRequest: {}", pacienteRequest);
        Paciente pacienteFound = pacienteRepository.findByUsuarioAndDni(pacienteRequest.getUsuario(), pacienteRequest.getDni());
        PacienteResponse pacienteResponse;
        if (pacienteFound != null) {
            pacienteResponse = modelMapper.map(pacienteFound, PacienteResponse.class);
        } else {
            throw new Exception("Las credenciales ingresadas son incorrectas");
        }
        log.info("Fin - PacienteServiceImpl::login - pacienteResponse: {}", pacienteResponse);
        return pacienteResponse;
    }
}
