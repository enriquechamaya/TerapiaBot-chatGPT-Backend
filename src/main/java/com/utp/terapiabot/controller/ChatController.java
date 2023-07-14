package com.utp.terapiabot.controller;

import com.utp.terapiabot.entity.Chat;
import com.utp.terapiabot.request.ChatRequest;
import com.utp.terapiabot.response.ChatResponse;
import com.utp.terapiabot.response.ResponseHandler;
import com.utp.terapiabot.services.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chats")
@Slf4j
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<Object> guardarChat(@RequestBody ChatRequest chatRequest) {
        try {
            log.info("[START] endpoint POST /api/chats :: chatRequest -  chatRequest: {}", chatRequest);
            ChatResponse chatResponse = chatService.guardarChat(chatRequest);
            return ResponseHandler.generateResponse("Saved", HttpStatus.OK, chatResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint POST /api/chats :: guardarChat");
        }
    }

}
