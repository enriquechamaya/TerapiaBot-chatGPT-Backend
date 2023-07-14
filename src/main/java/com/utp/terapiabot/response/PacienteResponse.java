package com.utp.terapiabot.response;

import lombok.Data;

@Data
public class PacienteResponse {
    private Integer id;
    private String usuario;
    private String dni;
    private Integer estado;
}
