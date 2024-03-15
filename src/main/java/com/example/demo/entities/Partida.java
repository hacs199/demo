package com.example.demo.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

@Table(name = "Partida")
public class Partida {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    private LocalDateTime fecha;
    private LocalDateTime hora_comienzo;
    private LocalDateTime hora_final;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;

    @ManyToMany(mappedBy = "partida")
    private List<Usuario> usuario;
}