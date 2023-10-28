package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.CarteiraVacinaDTO;
import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.repository.CarteiraVacinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarteiraVacinaService {

    @Autowired
    private CarteiraVacinaRepository carteiraVacinaRepository;


    public List<CarteiraVacinaDTO> findAll(){return this.carteiraVacinaRepository.findAll().stream().map(CarteiraVacina::toDTO).toList();}

    public CarteiraVacinaDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.carteiraVacinaRepository.getReferenceById(id).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Carteira de Vacina não Encontrada");
        }
    }

    public CarteiraVacinaDTO save(CarteiraVacinaDTO carteiraVacinaDTO) throws ControllerNotFoundException {
        return carteiraVacinaRepository.save(carteiraVacinaDTO.toModel()).toDTO();
    }

    public CarteiraVacinaDTO update(UUID id, CarteiraVacinaDTO carteiraVacinaDTO) throws ControllerNotFoundException {
        try {
            CarteiraVacina carteiraVacina = this.carteiraVacinaRepository.getReferenceById(id);
            carteiraVacina.setUsuario(carteiraVacinaDTO.usuario());
            carteiraVacina.setNumeroSus(carteiraVacinaDTO.numeroSus());
            carteiraVacina.setVacinaAplicada(carteiraVacinaDTO.vacinaAplicada());

            return this.carteiraVacinaRepository.saveAndFlush(carteiraVacina).toDTO();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("CArteira de Vacina não Encontrada");
        }

    }

    public void delete(UUID id) throws ControllerNotFoundException {
        this.carteiraVacinaRepository.deleteById(id);
    }
}