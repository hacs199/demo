package com.example.demo.dto.partida;

import java.time.LocalDateTime;

public record PartidaDto (Long id,
                         String creador,
                         String deporte,
                         String ciudad,
                         String provincia,
                         LocalDateTime fecha,
                         LocalDateTime hora_comienzo,
                         LocalDateTime hora_final,
                         Integer participantes,
                         Integer suplentes,
                         String comentarios){
}
