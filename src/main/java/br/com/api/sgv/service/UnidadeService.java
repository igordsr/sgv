package br.com.api.sgv.service;

import br.com.api.sgv.controller.exception.ControllerNotFoundException;
import br.com.api.sgv.dto.UnidadeDTO;
import br.com.api.sgv.entities.Unidade;
import br.com.api.sgv.repository.UnidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<UnidadeDTO> findAll() {
        return this.unidadeRepository.findAll().stream().map(Unidade::toDto).toList();
    }

    public UnidadeDTO findById(UUID id) throws ControllerNotFoundException {
        try {
            return this.unidadeRepository.getReferenceById(id).toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Unidade não Encontrada");
        }
    }

    public UnidadeDTO save(UnidadeDTO unidadeDTO) throws ControllerNotFoundException {
        Unidade unidade = new Unidade(unidadeDTO.nome(), unidadeDTO.registroUnidade(), unidadeDTO.situacao(), unidadeDTO.vacinas());
        unidade = this.unidadeRepository.save(unidade);
        return unidade.toDto();

    }
    public UnidadeDTO update(UUID id, UnidadeDTO unidadeDTO) throws ControllerNotFoundException {
        try {
            Unidade unidade = this.unidadeRepository.getReferenceById(id);
            unidade.setNome(unidadeDTO.nome());
            unidade.setRegistroUnidade(unidadeDTO.registroUnidade());
            unidade.setSituacao(unidadeDTO.situacao());
            unidade.setVacinas(unidadeDTO.vacinas());
            this.unidadeRepository.saveAndFlush(unidade);
            return unidade.toDto();
        } catch (EntityNotFoundException exception) {
            throw new ControllerNotFoundException("Unidade não Encontrada");
        }

    }
    public void delete(UUID id) throws ControllerNotFoundException {
        this.unidadeRepository.deleteById(id);
    }

}
