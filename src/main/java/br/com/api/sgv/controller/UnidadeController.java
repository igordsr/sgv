package br.com.api.sgv.controller;

import br.com.api.sgv.dto.UnidadeDTO;
import br.com.api.sgv.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {
    @Autowired
    private UnidadeService unidadeService;
    @GetMapping
    public ResponseEntity<List<UnidadeDTO>> findAll() {
        var unidadesDTO = this.unidadeService.findAll();
        return ResponseEntity.ok(unidadesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeDTO> findById(@PathVariable UUID id) {
        final UnidadeDTO unidadeDTO = this.unidadeService.findById(id);
        return ResponseEntity.ok(unidadeDTO);
    }

    @PostMapping
    public ResponseEntity<UnidadeDTO> save(@RequestBody @Valid UnidadeDTO unidadeDTO) {
        unidadeDTO = this.unidadeService.save(unidadeDTO);
        return new ResponseEntity<>(unidadeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeDTO> update(@PathVariable UUID id, @RequestBody @Valid UnidadeDTO unidadeDTO) {
        unidadeDTO = this.unidadeService.update(id, unidadeDTO);
        return ResponseEntity.ok(unidadeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.unidadeService.delete(id);
    }
}
