package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.VacinaAplicadaDTO;
import br.com.api.sgv.entities.VacinaAplicada;
import br.com.api.sgv.repository.VacinaAplicadaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class VacinaAplicadaService {

    @Autowired
    private VacinaAplicadaRepository vacinaAplicadaRepository;


    public List<VacinaAplicadaDTO> findAll(){return this.vacinaAplicadaRepository.findAll().stream().map(VacinaAplicada::toDTO).toList();}

    public VacinaAplicadaDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.vacinaAplicadaRepository.getReferenceById(id).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina aplicada não Encontrada");
        }
    }

    public VacinaAplicadaDTO save(VacinaAplicadaDTO vacinaAplicadaDTO) throws ControllerNotFoundException {
        return vacinaAplicadaRepository.save(vacinaAplicadaDTO.toModel()).toDTO();
    }

    public VacinaAplicadaDTO update(UUID id, VacinaAplicadaDTO vacinaAplicadaDTO) throws ControllerNotFoundException {
        try {
            VacinaAplicada vacinaAplicada = this.vacinaAplicadaRepository.getReferenceById(id);
            vacinaAplicada.setVacina(vacinaAplicadaDTO.vacina());
            vacinaAplicada.setNomeVacina(vacinaAplicadaDTO.nomeVacina());
            vacinaAplicada.setDoseVacina(vacinaAplicadaDTO.doseVacina());
            vacinaAplicada.setDataAplicacao(vacinaAplicadaDTO.dataAplicacao());
            vacinaAplicada.setNumeroLote(vacinaAplicadaDTO.numeroLote());
            return this.vacinaAplicadaRepository.saveAndFlush(vacinaAplicada).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina Aplicada não Encontrada");
        }

    }

    public void delete(UUID id) throws ControllerNotFoundException {
        this.vacinaAplicadaRepository.deleteById(id);
    }
}