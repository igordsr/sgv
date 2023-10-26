package br.com.api.sgv.service;

import br.com.api.sgv.entities.Enfermeiro;
import br.com.api.sgv.repository.EnfermeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EnfermeiroService {
    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    public Enfermeiro criarEnferimeiro(Enfermeiro enfermeiro) {
        return enfermeiroRepository.save(enfermeiro);
    }

    public void deletarEnferimeiro(UUID id) {
        enfermeiroRepository.deleteById(id);
    }

    public void getEnfermeiroById(UUID id) {
        enfermeiroRepository.findById(id);
    }
}
