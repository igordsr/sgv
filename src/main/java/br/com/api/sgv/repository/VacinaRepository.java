package br.com.api.sgv.repository;

import br.com.api.sgv.entities.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, UUID> {
}
