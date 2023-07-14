package com.utp.terapiabot.repository;

import com.utp.terapiabot.entity.ChatLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLineRepository extends JpaRepository<ChatLine, Integer> {
}
