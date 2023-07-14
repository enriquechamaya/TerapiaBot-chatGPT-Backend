package com.utp.terapiabot.response;

import lombok.Data;

import java.util.Date;

@Data
public class ChatResponse {

    private int id;
    private int idTema;
    private int idPaciente;
    private Date createDate;
    private int estado;

}
