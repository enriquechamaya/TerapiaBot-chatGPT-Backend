package com.utp.terapiabot.services;

import com.utp.terapiabot.request.ChatRequest;
import com.utp.terapiabot.response.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    ChatResponse guardarChat(ChatRequest chatRequest) throws Exception;

}
