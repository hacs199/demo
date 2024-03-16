package com.example.demo.service;

import com.example.demo.dto.usuario.UsuarioDto;
import com.example.demo.dto.usuario.UsuarioToSaveDto;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario =
        return null;
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioToSaveDto usuarioDto) {
        return null;
    }

    @Override
    public UsuarioDto findUsuarioByid(Long id) {
        return null;
    }

    @Override
    public UsuarioDto findUsuarioByEmail(String email) {
        return null;
    }
}
