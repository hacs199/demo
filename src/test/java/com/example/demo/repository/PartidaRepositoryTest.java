package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Partida;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartidaRepositoryTest extends AbstractIntegrationDBTest {

    PartidaRepository partidaRepository;

    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository){
        this.partidaRepository = partidaRepository;
    }

    void initPartidas(){
        Partida partida = Partida.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .build();

        partidaRepository.save(partida);

        Partida partida1 = Partida.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();

        partidaRepository.save(partida1);
        partidaRepository.flush();
    }
    @BeforeEach
    void setUp() {
        partidaRepository.deleteAll();
    }
    @Test
    void partidas(){
        //Given
        Partida partida = Partida.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();
        //when
        Partida userSaved = partidaRepository.save(partida);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    void givenPartidasPorCreador_whenBuscar_thenObtienesUnaListaDePartidas(){
        Partida partida = Partida.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .build();

        partidaRepository.save(partida);

        Partida partida1 = Partida.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .build();

        partidaRepository.save(partida1);

        List<Partida> partidas = partidaRepository.findBycreador
                ("Gabriel");

        assertThat(partidas).isNotEmpty();
        assertThat(partidas).first().hasFieldOrPropertyWithValue("creador", "Gabriel");
    }

    @Test
    void buscarPartidasPorAno() {
        // Given
        int anobuscado = 2022;

        Partida partida1 = Partida.builder()
                .creador("Andres")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Clasificatoria")
                .fecha(LocalDateTime.of(2022, 3, 9, 12, 0))
                .build();
        partidaRepository.save(partida1);

        Partida partida2 = Partida.builder()
                .creador("Gabriel")
                .deporte("Tenis de mesa")
                .ciudad("Santa Marta")
                .comentarios("Fase de grupos")
                .fecha(LocalDateTime.of(2023, 3, 9, 12, 0))
                .build();
        partidaRepository.save(partida2);

        // When
        List<Partida> partidasDelAno = partidaRepository.findByAno(anobuscado);

        // Then
        assertThat(partidasDelAno).isNotEmpty();
        assertThat(partidasDelAno).allMatch(Partidas -> Partidas.getFecha().getYear() == anobuscado);
    }

}