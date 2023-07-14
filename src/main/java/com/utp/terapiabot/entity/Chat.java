package com.utp.terapiabot.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Chat {
    @Id
    @Column(name = "idchat")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idtema")
    private int idTema;
    @Column(name = "idpaciente")
    private int idPaciente;
    @Column(name = "createdate")
    private Date createDate;
    private int estado;
}
