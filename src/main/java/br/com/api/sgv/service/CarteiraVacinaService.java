package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.CarteiraVacinaDTO;
import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.repository.CarteiraVacinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class CarteiraVacinaService {

    @Autowired
    private CarteiraVacinaRepository carteiraVacinaRepository;

    public CarteiraVacina findByNumeroSus(BigInteger numeroSus) {
        try {
            return this.carteiraVacinaRepository.getReferenceByNumeroSus(numeroSus);
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Carteira de Vacina não Encontrada");
        }
    }
}