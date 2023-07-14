package com.utp.terapiabot.controller;

import com.utp.terapiabot.request.PacienteRequest;
import com.utp.terapiabot.request.TemaRequest;
import com.utp.terapiabot.response.PacienteResponse;
import com.utp.terapiabot.response.ResponseHandler;
import com.utp.terapiabot.response.TemaResponse;
import com.utp.terapiabot.services.TemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temas")
@Slf4j
public class TemaController {

    @Autowired
    private TemaService temaService;

    @PostMapping
    public ResponseEntity<Object> guardarTema(@RequestBody TemaRequest temaRequest) {
        try {
            log.info("[START] endpoint POST /api/temas :: guardarTema -  temaRequest: {}", temaRequest);
            TemaResponse temaResponse = temaService.guardarTema(temaRequest);
            return ResponseHandler.generateResponse("Saved", HttpStatus.OK, temaResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint POST /api/temas :: guardarTema");
        }
    }

}
