package com.utp.terapiabot.repository;

import com.utp.terapiabot.entity.ChatLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLineRepository extends JpaRepository<ChatLine, Integer> {
    List<ChatLine> findAllByIdChat(Integer idChat);

}
