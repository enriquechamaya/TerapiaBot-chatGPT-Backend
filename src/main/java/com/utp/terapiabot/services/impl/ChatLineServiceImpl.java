package com.utp.terapiabot.services.impl;

import com.utp.terapiabot.entity.Chat;
import com.utp.terapiabot.entity.ChatLine;
import com.utp.terapiabot.repository.ChatLineRepository;
import com.utp.terapiabot.request.ChatLineRequest;
import com.utp.terapiabot.response.ChatLineResponse;
import com.utp.terapiabot.response.ChatResponse;
import com.utp.terapiabot.services.ChatLineService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ChatLineServiceImpl implements ChatLineService {
    @Autowired
    private ChatLineRepository chatLineRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public ChatLineResponse guardarChatLine(ChatLineRequest chatLineRequest) {
        log.info("Inicio - ChatServiceImpl::guardarChatLine - chatLineRequest: {}", chatLineRequest);
        ChatLine chatLine = chatLineRepository.save(modelMapper.map(chatLineRequest, ChatLine.class));
        ChatLineResponse chatLineResponse = modelMapper.map(chatLine, ChatLineResponse.class);
        log.info("Fin - ChatServiceImpl::guardarChatLine - chatLineResponse: {}", chatLineResponse);
        return chatLineResponse;
    }
}
