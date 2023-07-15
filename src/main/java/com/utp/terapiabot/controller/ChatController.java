package com.utp.terapiabot.controller;

import com.utp.terapiabot.entity.Chat;
import com.utp.terapiabot.request.ChatLineRequest;
import com.utp.terapiabot.request.ChatRequest;
import com.utp.terapiabot.response.ChatLineResponse;
import com.utp.terapiabot.response.ChatResponse;
import com.utp.terapiabot.response.ResponseHandler;
import com.utp.terapiabot.services.ChatLineService;
import com.utp.terapiabot.services.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@Slf4j
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatLineService chatLineService;

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

    @PostMapping("/chatline")
    public ResponseEntity<Object> guardarChatLine(@RequestBody ChatLineRequest chatLineRequest) {
        try {
            log.info("[START] endpoint POST /api/chats/chatline :: guardarChatLine -  chatLineRequest: {}", chatLineRequest);
            ChatLineResponse chatLineResponse = chatLineService.guardarChatLine(chatLineRequest);
            return ResponseHandler.generateResponse("Saved", HttpStatus.OK, chatLineResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint POST /api/chats/chatline :: guardarChatLine");
        }
    }

    @GetMapping("/chatline/{idChat}")
    public ResponseEntity<Object> listarChatLine(@PathVariable Integer idChat) {
        try {
            log.info("[START] endpoint GET /api/chats/chatline :: listarChatLine -  idChat: {}", idChat);
            List<ChatLineResponse> chatLineResponseList = chatLineService.listarChatLine(idChat);
            return ResponseHandler.generateResponse("List", HttpStatus.OK, chatLineResponseList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        } finally {
            log.info("[END] endpoint GET /api/chats/chatline :: listarChatLine");
        }
    }

}
