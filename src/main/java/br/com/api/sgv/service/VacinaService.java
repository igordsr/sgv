package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.VacinaDTO;
import br.com.api.sgv.entities.Vacina;
import br.com.api.sgv.repository.VacinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;


    public List<VacinaDTO> findAll(){return this.vacinaRepository.findAll().stream().map(Vacina::toDTO).toList();}

    public VacinaDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.vacinaRepository.getReferenceById(id).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina não Encontrada");
        }
    }

    public VacinaDTO save(VacinaDTO vacinaDTO) throws ControllerNotFoundException {
        return vacinaRepository.save(vacinaDTO.toModel()).toDTO();
    }

    public VacinaDTO update(UUID id, VacinaDTO vacinaDTO) throws ControllerNotFoundException {
        try {
            Vacina vacina = this.vacinaRepository.getReferenceById(id);
            vacina.setNomeVacina(vacinaDTO.nomeVacina());
            vacina.setDoseVacina(vacinaDTO.doseVacina());
            vacina.setNumeroLote(vacinaDTO.numeroLote());
            vacina.setQuantidade(vacinaDTO.quantidade());
            return this.vacinaRepository.saveAndFlush(vacina).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina não Encontrada");
        }

    }

    public void delete(UUID id) throws ControllerNotFoundException {
        this.vacinaRepository.deleteById(id);
    }
}
