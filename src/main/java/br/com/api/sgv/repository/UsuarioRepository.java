package br.com.api.sgv.repository;

import br.com.api.sgv.entities.Paciente;
import br.com.api.sgv.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}

