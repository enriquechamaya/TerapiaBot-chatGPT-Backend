package com.utp.terapiabot.services;

import com.utp.terapiabot.request.ChatLineRequest;
import com.utp.terapiabot.response.ChatLineResponse;
import org.springframework.stereotype.Service;

@Service
public interface ChatLineService {

    ChatLineResponse guardarChatLine(ChatLineRequest chatLineRequest);

}
