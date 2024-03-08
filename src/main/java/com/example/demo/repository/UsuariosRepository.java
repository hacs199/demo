package com.example.demo.repository;

import com.example.demo.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> finByNombreAndApellido(String nombre, String apellido);

    @Query("select u from Usuarios u where u.nombre = ?1" )
    List<Usuarios> findBynombre(String nombre);

}