package com.example.demo.dto.usuario;

import com.example.demo.dto.Mensaje.MensajeMapper;
import com.example.demo.dto.Sugerencia.SugerenciaMapper;
import com.example.demo.entities.Sugerencia;
import com.example.demo.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    /*
    private SugerenciaMapper sugerenciaMapper;
    public Usuario usuarioDtoUsuarioEntity(UsuarioDto usuarioDto){
        Usuario usuario= new Usuario();
        usuario.setNombre(usuarioDto.nombre());
        usuario.setApellido(usuarioDto.apellido());
        usuario.setEmail(usuarioDto.email());
        usuario.setId(usuarioDto.id());
        List<Sugerencia> sugerencia = usuarioDto.sugerencias()
                .stream()
                .map(SugerenciaMapper::sugerenciaDtoToSugerenciaEntity)
                .collect(Collectors.toList());
        usuario.setSugerencia(sugerencia);
        return usuario;

        var sugerencias = usuarioDto.sugerencias()
                .stream()
                .map(SugerenciaMapper::sugerenciaDtoToSugerenciaEntity)
                .collect(Collectors.toList());
        usuario.setSugerencia(sugerencias);

        var mensajes = usuarioDto.mensajes()
                .stream()
                .map(MensajeMapper::mensajeDtoMensajeEntity)
                .collect(Collectors.toList());
        usuario.setMensaje(mensajes);
        return usuario;
    }

    public static Usuario usuarioSaveDtoToUsuarioEntity(UsuarioToSaveDto usuarioDto){
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .username(usuarioDto.username())
                .password(usuarioDto.password())
                .email(usuarioDto.email())
                .build();

    }
    public UsuarioDto usuarioEntityToUsuarioDto(Usuario usuario){
        var sugerencias = usuario.getSugerencia()
                .stream()
                .map(SugerenciaMapper::sugerenciaEntityToSugerenciaDto)
                .collect(Collectors.toList());
        var mensajes =usuario.getMensaje()
                .stream()
                .map(MensajeMapper::mensajeEntityToMensajeDto)
                .collect(Collectors.toList());
        return new UsuarioDto(usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getUsername(),
                usuario.getEmail(),
                sugerencias, mensajes);
    }*/
}
