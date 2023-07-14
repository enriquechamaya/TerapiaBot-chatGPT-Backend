package com.utp.terapiabot.services;

import com.utp.terapiabot.request.TemaRequest;
import com.utp.terapiabot.response.TemaResponse;
import org.springframework.stereotype.Service;

@Service
public interface TemaService {

    TemaResponse guardarTema(TemaRequest temaRequest) throws Exception;

}
