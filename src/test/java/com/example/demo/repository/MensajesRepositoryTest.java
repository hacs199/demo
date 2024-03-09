package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Mensajes;
import com.example.demo.entities.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MensajesRepositoryTest extends AbstractIntegrationDBTest {

    MensajesRepository mensajesRepository;

    @Autowired
    public MensajesRepositoryTest(MensajesRepository mensajesRepository){
        this.mensajesRepository = mensajesRepository;
    }

    void initMEnsajes(){
        Mensajes mensaje = Mensajes.builder()
                .creador("pedro")
                .contenido("aaaaa")
                .create_at(LocalDateTime.parse("1/1/1970"))
                .build();

        mensajesRepository.save(mensaje);

        Mensajes mensaje2 = Mensajes.builder()
                .creador("Pablo")
                .contenido("bb")
                .create_at(LocalDateTime.parse("11/11/2021"))
                .build();

        mensajesRepository.save(mensaje2);
        mensajesRepository.flush();
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void mensajesbacanos(){
        Mensajes mensaje = Mensajes.builder()
                .creador("adara")
                .contenido("aaaaa")
                .create_at(LocalDateTime.parse("1/1/1970"))
                .build();
        //when
        Mensajes userSaved = mensajesRepository.save(mensaje);
        //then
        assertThat(userSaved.getId()).isNotNull();
    }


}