package br.com.api.sgv.service;

import br.com.api.sgv.entities.Paciente;
import br.com.api.sgv.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletarPaciente(UUID id) {
        pacienteRepository.deleteById(id);
    }

    public void getPacienteById(UUID id) {
        pacienteRepository.findById(id);
    }
}
