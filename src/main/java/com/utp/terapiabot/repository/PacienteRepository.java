package com.utp.terapiabot.repository;

import com.utp.terapiabot.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByUsuario(String usuario);
    Paciente findByUsuarioAndDni(String usuario, String dni);
}
