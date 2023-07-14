package com.utp.terapiabot.response;

import lombok.Data;

import java.util.Date;

@Data
public class ChatLineResponse {
    private int id;
    private int idChat;
    private String messageRequest;
    private String messageResponse;
    private Date createDate;
}
