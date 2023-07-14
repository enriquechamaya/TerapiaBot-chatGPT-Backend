package com.utp.terapiabot.entity;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idchat")
    private int idChat;
    @Column(name = "message_request")
    private String messageRequest;
    @Column(name = "message_response")
    private String messageResponse;
    @Column(name = "createdate")
    private Date createDate;
}
