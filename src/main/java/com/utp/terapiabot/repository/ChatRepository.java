package com.utp.terapiabot.repository;

import com.utp.terapiabot.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findByIdTemaAndIdPaciente(int idTema, int idPaciente);
}
