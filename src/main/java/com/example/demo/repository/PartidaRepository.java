package com.example.demo.repository;

import com.example.demo.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findBydate(LocalDateTime fecha);

    @Query("select p from Partida p where p.participantes = ?1")
            List<Partida> findByParticipantes (Integer participantes);

    List<Partida> findBycreador(String nombre);

    List<Partida> findByAno(int fecha);
}
