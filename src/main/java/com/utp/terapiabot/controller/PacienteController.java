package com.utp.terapiabot.controller;

import com.utp.terapiabot.entity.Paciente;
import com.utp.terapiabot.request.PacienteRequest;
import com.utp.terapiabot.response.PacienteResponse;
import com.utp.terapiabot.response.ResponseHandler;
import com.utp.terapiabot.services.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacientes")
@Slf4j
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Object> guardarPaciente(@RequestBody PacienteRequest pacienteRequest) {
        try {
            log.info("[START] endpoint POST /api/pacientes :: guardarPaciente -  pacienteRequest: {}", pacienteRequest);
            PacienteResponse pacienteResponse = pacienteService.guardarPaciente(pacienteRequest);
            return ResponseHandler.generateResponse("Saved", HttpStatus.OK, pacienteResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint POST /api/pacientes :: guardarPaciente");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody PacienteRequest pacienteRequest) {
        try {
            log.info("[START] endpoint POST /api/login :: login -  pacienteRequest: {}", pacienteRequest);
            PacienteResponse pacienteResponse = pacienteService.login(pacienteRequest);
            return ResponseHandler.generateResponse("Logged", HttpStatus.OK, pacienteResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint POST /api/login :: login");
        }
    }

}
