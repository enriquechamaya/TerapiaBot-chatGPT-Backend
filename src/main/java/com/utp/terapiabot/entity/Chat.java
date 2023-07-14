package com.utp.terapiabot.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private int id;
    private int idTema;
    private Date createDate;
    private int estado;
}
