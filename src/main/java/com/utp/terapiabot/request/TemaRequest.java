package com.utp.terapiabot.request;

import lombok.Data;

@Data
public class TemaRequest {
    private String descripcion;
    private int estado = 1;
}
