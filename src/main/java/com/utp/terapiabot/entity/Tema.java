package com.utp.terapiabot.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Tema {
    @Id
    @Column(name = "idtema")
    private int id;
    private String descripcion;
    private int estado;
}
