package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Sugerencias")
public class Sugerencias {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDateTime create_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Usuarios usuario;
}