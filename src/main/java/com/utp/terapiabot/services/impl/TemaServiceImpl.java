package com.utp.terapiabot.services.impl;

import com.utp.terapiabot.entity.Paciente;
import com.utp.terapiabot.entity.Tema;
import com.utp.terapiabot.repository.TemaRepository;
import com.utp.terapiabot.request.TemaRequest;
import com.utp.terapiabot.response.PacienteResponse;
import com.utp.terapiabot.response.TemaResponse;
import com.utp.terapiabot.services.TemaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TemaServiceImpl implements TemaService {

    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public TemaResponse guardarTema(TemaRequest temaRequest) throws Exception {
        log.info("Inicio - TemaServiceImpl::guardarTema - temaRequest: {}", temaRequest);
        Tema temaFound = temaRepository.findByDescripcion(temaRequest.getDescripcion());
        TemaResponse temaResponse;
        if (temaFound == null) {
            Tema tema = temaRepository.save(modelMapper.map(temaRequest, Tema.class));
            temaResponse = modelMapper.map(tema, TemaResponse.class);
        } else {
            throw new Exception("Ya existe un tema con el mismo nombre");
        }
        log.info("Fin - TemaServiceImpl::guardarTema - pacienteResponse: {}", temaResponse);
        return temaResponse;
    }
}
