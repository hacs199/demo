package com.example.demo.repository;

import com.example.demo.entities.Mensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajesRepository extends JpaRepository<Mensajes, Long> {

    Optional<Mensajes> findById (Long id);

    List<Mensajes> findByContenido(String contenido);
}
