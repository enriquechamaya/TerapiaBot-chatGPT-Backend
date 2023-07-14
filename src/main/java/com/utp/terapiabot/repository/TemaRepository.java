package com.utp.terapiabot.repository;

import com.utp.terapiabot.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {
    Tema findByDescripcion(String descripcion);
}
