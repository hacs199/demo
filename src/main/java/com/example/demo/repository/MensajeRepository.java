package com.example.demo.repository;

import com.example.demo.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    Optional<Mensaje> findById (Long id);

    List<Mensaje> findByContenido(String contenido);
}
