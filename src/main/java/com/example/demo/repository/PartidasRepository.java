package com.example.demo.repository;

import com.example.demo.entities.Partidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PartidasRepository extends JpaRepository<Partidas, Long> {

    List<Partidas> findBydate(LocalDateTime fecha);

    @Query("select p from Partidas p where p.participantes = ?1")
            List<Partidas> findByParticipantes (Integer participantes);
}
