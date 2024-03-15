package com.example.demo.dto.usuario;


import com.example.demo.dto.Mensaje.MensajeDto;
import com.example.demo.dto.Sugerencia.SugerenciaDto;
import com.example.demo.entities.Mensaje;

import java.util.Collections;
import java.util.List;

public record UsuarioDto (Long id,
                          String nombre,
                          String apellido,
                          String userName,
                          String email,
                          //Integer edad,
                          //String password,
                          //String rep_password,
                          //Boolean enable,
                          //String foto,
                          //String rol,
                          //LocalDateTime create_at,
                          List<SugerenciaDto> sugerencias,
                          List<MensajeDto> mensajes) {
    public List<SugerenciaDto> sugerencias(){
        return Collections.unmodifiableList(sugerencias());
    }
    public List<MensajeDto> mensajes(){
        return Collections.unmodifiableList(mensajes());
    }

}