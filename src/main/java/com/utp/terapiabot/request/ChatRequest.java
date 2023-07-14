package com.utp.terapiabot.request;

import lombok.Data;

import java.util.Date;

@Data
public class ChatRequest {

    private int id;
    private int idTema;
    private int idPaciente;
    private Date createDate = new Date();
    private int estado = 1;

}
