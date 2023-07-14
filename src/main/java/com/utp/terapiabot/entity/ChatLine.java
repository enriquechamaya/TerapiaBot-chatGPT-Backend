package com.utp.terapiabot.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "chat_line")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ChatLine {
    @Id
    @Column(name = "idchat_line")
    private int id;
    @Column(name = "idchat")
    private int idChat;
    @Column(name = "idpaciente")
    private int idPaciente;
    @Column(name = "message_request")
    private String messageRequest;
    @Column(name = "message_response")
    private String messageResponse;
    @Column(name = "createdate")
    private Date createDate;
}
