package com.utp.terapiabot.request;

import lombok.Data;

import java.util.Date;

@Data
public class ChatLineRequest {

    private int id;
    private int idChat;
    private String messageRequest;
    private String messageResponse;
    private Date createDate = new Date();

}
