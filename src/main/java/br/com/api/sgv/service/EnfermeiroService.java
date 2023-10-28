package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.EnfermeiroDTO;
import br.com.api.sgv.entities.Enfermeiro;
import br.com.api.sgv.repository.EnfermeiroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EnfermeiroService {
    @Autowired
    private EnfermeiroRepository enfermeiroRepository;

    public EnfermeiroDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.enfermeiroRepository.getReferenceById(id).toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Enfermeiro não Encontrado");
        }
    }

    public EnfermeiroDTO save(EnfermeiroDTO enfermeiroDTO) throws ControllerNotFoundException {
        Enfermeiro enfermeiro = new Enfermeiro(enfermeiroDTO.nome(), enfermeiroDTO.email(), enfermeiroDTO.senha(), enfermeiroDTO.rg(), enfermeiroDTO.dataNascimento(), enfermeiroDTO.numeroCoren());
        enfermeiro = this.enfermeiroRepository.save(enfermeiro);
        return enfermeiro.toDto();
    }
    public EnfermeiroDTO update(UUID id, EnfermeiroDTO enfermeiroDTO) throws ControllerNotFoundException {
        try {
            Enfermeiro enfermeiro = this.enfermeiroRepository.getReferenceById(id);

            enfermeiro.setNome(enfermeiroDTO.nome());
            enfermeiro.setEmail(enfermeiroDTO.email());
            enfermeiro.setSenha(enfermeiroDTO.senha());
            enfermeiro.setRg(enfermeiroDTO.rg());
            enfermeiro.setDataNascimento(enfermeiroDTO.dataNascimento());
            enfermeiro.setNumeroCoren(enfermeiroDTO.numeroCoren());
            this.enfermeiroRepository.saveAndFlush(enfermeiro);
            return enfermeiro.toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Enfermeiro não Encontrado");
        }

    }
    public void delete(UUID id) throws ControllerNotFoundException {
        this.enfermeiroRepository.deleteById(id);
    }

}
