package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.PacienteDTO;
import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.entities.Paciente;
import br.com.api.sgv.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.pacienteRepository.getReferenceById(id).toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Paciente não Encontrada");
        }
    }

    public PacienteDTO save(PacienteDTO pacienteDTO) throws ControllerNotFoundException {
        Paciente paciente = pacienteDTO.toModel();
        paciente = this.pacienteRepository.save(paciente);
        return paciente.toDto();
    }

    public PacienteDTO update(UUID id, PacienteDTO pacienteDTO) throws ControllerNotFoundException {
        try {
            Paciente paciente = this.pacienteRepository.getReferenceById(id);
            CarteiraVacina carteiraVacina = pacienteDTO.toModel().getCarteiraVacina();

            paciente.setNome(pacienteDTO.nome());
            paciente.setEmail(pacienteDTO.email());
            paciente.setSenha(pacienteDTO.senha());
            paciente.setRg(pacienteDTO.rg());
            paciente.setDataNascimento(pacienteDTO.dataNascimento());
            paciente.getCarteiraVacina().setNumeroSus(carteiraVacina.getNumeroSus());

            this.pacienteRepository.saveAndFlush(paciente);
            return paciente.toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Paciente não Encontrada");
        }

    }
    @Deprecated
    public void delete(UUID id) throws ControllerNotFoundException {
        this.pacienteRepository.deleteById(id);
    }

}
