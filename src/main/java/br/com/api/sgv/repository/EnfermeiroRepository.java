package br.com.api.sgv.repository;

import br.com.api.sgv.entities.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, UUID> {
}
