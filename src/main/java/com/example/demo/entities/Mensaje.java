package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Mensaje {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String creador;
    private String contenido;
    private LocalDateTime create_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Usuario usuario;
}