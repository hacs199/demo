package com.example.demo.repository;

import com.example.demo.AbstractIntegrationDBTest;
import com.example.demo.entities.Usuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsuariosRepositoryTest extends AbstractIntegrationDBTest {

    UsuariosRepository usuariosRepository;


    @Autowired
    public UsuariosRepositoryTest(UsuariosRepository usuariosRepository){
        this.usuariosRepository = usuariosRepository;
    }
    void initMockUsuarios(){
        Usuarios usuario = Usuarios.builder()
                .nombre("andres")
                .apellido("Alvarez")
                .username("andresalvarez")
                .password("123")
                .build();
        usuariosRepository.save(usuario);

        Usuarios usuario2 = Usuarios.builder().nombre("hernan")
                .apellido("chaverra")
                .username("hernanchaverra")
                .password("123")
                .build();
        usuariosRepository.save(usuario2);
        usuariosRepository.flush();
    }

    @BeforeEach
    void setUp() {

        usuariosRepository.deleteAll();

    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuarios usuario = Usuarios.builder()
                .nombre("camilo")
                .apellido("alvarez")
                .username("andresalvarez")
                .password("123")
                .build();
        //when
        Usuarios userSaved = usuariosRepository.save(usuario);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Usuarios usuario = Usuarios.builder()
                .nombre("andres")
                .apellido("alvarez")
                .username("andresalvarez")
                .password("123")
                .build();
        usuariosRepository.save(usuario);

        Usuarios usuario2 = Usuarios.builder().nombre("hernan")
                .apellido("chaverra")
                .username("hernanchavaerra")
                .password("123")
                .build();
        usuariosRepository.save(usuario2);
        usuariosRepository.flush();
        //WHEN
        List<Usuarios> usuarios = usuariosRepository.findAll();

        //THEN
        assertThat(usuarios).hasSize(2);
    }
    @Test
    void givenUsuarios_whenBuscarPorNombreyApellido_thenObtienesUnaListaDeUsuarios(){
        Usuarios usuario = Usuarios.builder()
                .nombre("andres")
                .apellido("alvarez")
                .username("andresalvarez")
                .password("123")
                .build();
        usuariosRepository.save(usuario);
        Usuarios usuario2 = Usuarios.builder().nombre("hernan")
                .apellido("chaverra")
                .username("hernanchaverra")
                .password("123")
                .build();
        usuariosRepository.save(usuario);

        List<Usuarios> usuarios = usuariosRepository.findBynombreAAndApellido
                ("andres", "alvarez");

        assertThat(usuarios).isNotEmpty();
        assertThat(usuarios).first().hasFieldOrPropertyWithValue("nombre","andres");
    }

}