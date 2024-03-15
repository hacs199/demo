package com.example.demo.repository;

import com.example.demo.entities.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {
    List<Sugerencia> findByDescripcionSugerencia(String descripción);
    List<Sugerencia> findBydate(LocalDateTime create_at);

}
