package com.example.demo.repository;

import com.example.demo.entities.Partidas;
import com.example.demo.entities.Sugerencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SugerenciasRepository extends JpaRepository<Sugerencias, Long> {
    List<Sugerencias> findByDescripcionSugerencia(String descripción);
    List<Sugerencias> findBydate(LocalDateTime create_at);

}
