package com.utp.terapiabot.request;

import lombok.Data;

@Data
public class PacienteRequest {
    private Integer id;
    private String usuario;
    private String dni;
    private Integer estado = 1;
}
