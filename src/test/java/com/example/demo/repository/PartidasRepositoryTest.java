package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Mensajes;
import com.example.demo.entities.Partidas;
import com.example.demo.entities.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartidasRepositoryTest extends AbstractIntegrationDBTest {

    PartidasRepository partidasRepository;

    @Autowired
    public PartidasRepositoryTest(PartidasRepository partidasRepository){
        this.partidasRepository = partidasRepository;
    }

    void initPartidas(){
        Partidas partida = Partidas.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .build();

        partidasRepository.save(partida);

        Partidas partida1 = Partidas.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();

        partidasRepository.save(partida1);
        partidasRepository.flush();
    }
    @BeforeEach
    void setUp() {
        partidasRepository.deleteAll();
    }
    @Test
    void partidas(){
        //Given
        Partidas partida = Partidas.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();
        //when
        Partidas userSaved = partidasRepository.save(partida);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    void givenPartidasPorCreador_whenBuscar_thenObtienesUnaListaDePartidas(){
        Partidas partida = Partidas.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .build();

        partidasRepository.save(partida);

        Partidas partida1 = Partidas.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();

        partidasRepository.save(partida1);

        List<Partidas> partidas = partidasRepository.findBycreador
                ("Gabriel");

        assertThat(partidas).isNotEmpty();
        assertThat(partidas).first().hasFieldOrPropertyWithValue("creador", "Gabriel");
    }

    @Test
    void buscarPartidasPorAno() {
        // Given
        int anobuscado = 2022;

        Partidas partida1 = Partidas.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .fecha(LocalDateTime.of(2022, 3, 9, 12, 0))
                .build();
        partidasRepository.save(partida1);

        Partidas partida2 = Partidas.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .fecha(LocalDateTime.of(2023, 3, 9, 12, 0))
                .build();
        partidasRepository.save(partida2);

        // When
        List<Partidas> partidasDelAno = partidasRepository.findByAno(anobuscado);

        // Then
        assertThat(partidasDelAno).isNotEmpty();
        assertThat(partidasDelAno).allMatch(Partidas -> Partidas.getFecha().getYear() == anobuscado);
    }

}