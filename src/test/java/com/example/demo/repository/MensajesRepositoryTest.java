package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Mensaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class MensajesRepositoryTest extends AbstractIntegrationDBTest {

    MensajeRepository mensajeRepository;

    @Autowired
    public MensajesRepositoryTest(MensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }

    void initMEnsajes(){
        Mensaje mensaje = Mensaje.builder()
                .creador("pedro")
                .contenido("aaaaa")
                .create_at(LocalDateTime.parse("1/1/1970"))
                .build();

        mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador("Pablo")
                .contenido("bb")
                .create_at(LocalDateTime.parse("11/11/2021"))
                .build();

        mensajeRepository.save(mensaje2);
        mensajeRepository.flush();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void mensajesbacanos(){
        Mensaje mensaje = Mensaje.builder()
                .creador("adara")
                .contenido("aaaaa")
                .create_at(LocalDateTime.parse("1/1/1970"))
                .build();
        //when
        Mensaje userSaved = mensajeRepository.save(mensaje);
        //then
        assertThat(userSaved.getId()).isNotNull();
    }


}