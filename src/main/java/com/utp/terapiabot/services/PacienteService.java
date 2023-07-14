package com.utp.terapiabot.services;

import com.utp.terapiabot.request.PacienteRequest;
import com.utp.terapiabot.response.PacienteResponse;
import org.springframework.stereotype.Service;

@Service
public interface PacienteService {

    PacienteResponse guardarPaciente(PacienteRequest pacienteRequest) throws Exception;
    PacienteResponse login(PacienteRequest pacienteRequest) throws Exception;

}
