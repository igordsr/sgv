package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.controller.exception.DoseException;
import br.com.api.sgv.controller.exception.ValidationMessage;
import br.com.api.sgv.dto.VacinaAplicadaDTO;
import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.entities.Vacina;
import br.com.api.sgv.entities.VacinaAplicada;
import br.com.api.sgv.repository.VacinaAplicadaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class VacinaAplicadaService {

    @Autowired
    private VacinaAplicadaRepository vacinaAplicadaRepository;

    @Autowired
    private CarteiraVacinaService carteiraVacinaService;

    @Autowired
    private VacinaService vacinaService;


    public List<VacinaAplicadaDTO> findAll() {
        return this.vacinaAplicadaRepository.findAll().stream().map(VacinaAplicada::toDTO).toList();
    }

    public VacinaAplicadaDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.vacinaAplicadaRepository.getReferenceById(id).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina aplicada não Encontrada");
        }
    }

    public VacinaAplicadaDTO save(VacinaAplicadaDTO vacinaAplicadaDTO) throws ControllerNotFoundException {
        CarteiraVacina carteiraVacina = this.carteiraVacinaService.findByNumeroSus(vacinaAplicadaDTO.numeroSus());
        Vacina vacina = this.vacinaService.findById(vacinaAplicadaDTO.vacinaId()).toModel();

        List<VacinaAplicada> vacinasAplicadas = vacinaAplicadaRepository.findAll();

        for(VacinaAplicada vacinaAplicada: vacinasAplicadas){

            if(Objects.equals(vacinaAplicada.getDoseVacina(), vacinaAplicadaDTO.doseVacina())){
                throw new DoseException("A Dose da vacina não pode ser a Mesma");
            }
        }

        VacinaAplicada vacinaAplicada = new VacinaAplicada(carteiraVacina, vacina, vacinaAplicadaDTO.doseVacina(), vacinaAplicadaDTO.dataAplicacao());
        return vacinaAplicadaRepository.save(vacinaAplicada).toDTO();
    }

    public VacinaAplicadaDTO update(UUID id, VacinaAplicadaDTO vacinaAplicadaDTO) throws ControllerNotFoundException {
        try {
            VacinaAplicada vacinaAplicada = this.vacinaAplicadaRepository.getReferenceById(id);
            CarteiraVacina carteiraVacina = this.carteiraVacinaService.findByNumeroSus(vacinaAplicadaDTO.numeroSus());
            Vacina vacina = this.vacinaService.findById(vacinaAplicadaDTO.vacinaId()).toModel();

            vacinaAplicada.setVacina(vacina);
            vacinaAplicada.setCarteiraVacina(carteiraVacina);
            vacinaAplicada.setDoseVacina(vacinaAplicadaDTO.doseVacina());
            vacinaAplicada.setDataAplicacao(vacinaAplicadaDTO.dataAplicacao());
            return this.vacinaAplicadaRepository.saveAndFlush(vacinaAplicada).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Vacina Aplicada não Encontrada");
        }
    }

    public void delete(UUID id) throws ControllerNotFoundException {
        this.vacinaAplicadaRepository.deleteById(id);
    }
}