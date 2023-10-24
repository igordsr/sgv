package br.com.api.sgv.repository;

import br.com.api.sgv.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, UUID> {
}
