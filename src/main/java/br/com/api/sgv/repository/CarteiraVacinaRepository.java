package br.com.api.sgv.repository;

import br.com.api.sgv.entities.CarteiraVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Repository
public interface CarteiraVacinaRepository extends JpaRepository<CarteiraVacina, UUID> {
    CarteiraVacina getReferenceByNumeroSus(BigInteger numeroSus);
}
