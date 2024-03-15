package com.example.demo.dto.usuario;

import com.example.demo.dto.Mensaje.MensajeDto;
import com.example.demo.dto.Sugerencia.SugerenciaDto;

import java.util.Collections;
import java.util.List;

public record UsuarioToSaveDto
    (Long id,
    String nombre,
    String apellido,
    String username,
    String email,
    String password) {
       /* public List<SugerenciaDto> sugerencias(){
            return Collections.unmodifiableList(sugerencias());
        }*/

        public List<SugerenciaDto> sugerencias(){
            return Collections.unmodifiableList(sugerencias());
        }

        public List<MensajeDto> mensajes(){
            return Collections.unmodifiableList(mensajes());
        }
}
