package com.example.demo.service;

import com.example.demo.dto.usuario.UsuarioDto;
import com.example.demo.dto.usuario.UsuarioToSaveDto;
import com.example.demo.entities.Usuario;

public interface UsuarioService {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto actualizarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto findUsuarioByid(Long id);
    UsuarioDto findUsuarioByEmail(String email);
}
