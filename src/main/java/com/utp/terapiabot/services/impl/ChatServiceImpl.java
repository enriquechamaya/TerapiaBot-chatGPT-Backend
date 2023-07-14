package com.utp.terapiabot.services.impl;

import com.utp.terapiabot.entity.Chat;
import com.utp.terapiabot.repository.ChatRepository;
import com.utp.terapiabot.request.ChatRequest;
import com.utp.terapiabot.response.ChatResponse;
import com.utp.terapiabot.services.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public ChatResponse guardarChat(ChatRequest chatRequest) throws Exception {
        log.info("Inicio - ChatServiceImpl::guardarChat - chatRequest: {}", chatRequest);
        Chat chatFound = chatRepository.findByIdTemaAndIdPaciente(chatRequest.getIdTema(), chatRequest.getIdPaciente());
        ChatResponse chatResponse;
        if (chatFound == null) {
            Chat chat = chatRepository.save(modelMapper.map(chatRequest, Chat.class));
            chatResponse = modelMapper.map(chat, ChatResponse.class);
        } else {
            throw new Exception("Ya existe un chat con el mismo tema");
        }
        log.info("Fin - ChatServiceImpl::guardarChat - chatResponse: {}", chatResponse);
        return chatResponse;
    }
}
