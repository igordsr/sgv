package br.com.api.sgv.service;

import br.com.api.sgv.entities.Usuario;
import br.com.api.sgv.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(UUID id) {
        usuarioRepository.deleteById(id);
    }

    public void getUsuarioById(UUID id) {
        usuarioRepository.findById(id);
    }
}
