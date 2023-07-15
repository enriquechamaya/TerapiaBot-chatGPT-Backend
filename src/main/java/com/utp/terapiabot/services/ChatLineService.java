package com.utp.terapiabot.services;

import com.utp.terapiabot.entity.ChatLine;
import com.utp.terapiabot.request.ChatLineRequest;
import com.utp.terapiabot.response.ChatLineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatLineService {

    ChatLineResponse guardarChatLine(ChatLineRequest chatLineRequest);

    List<ChatLineResponse> listarChatLine(Integer idChat) throws Exception;

}
