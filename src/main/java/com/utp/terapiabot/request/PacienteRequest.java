package com.utp.terapiabot.request;

import lombok.Data;

@Data
public class PacienteRequest {
    private int id;
    private String usuario;
    private String dni;
    private int estado = 1;
}
