package br.com.api.sgv.controller;

import br.com.api.sgv.dto.EnfermeiroDTO;
import br.com.api.sgv.service.EnfermeiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enfermeiro")
public class EnfermeiroController {
    @Autowired
    private EnfermeiroService enfermeiroService;

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeiroDTO> findById(@PathVariable UUID id) {
        final EnfermeiroDTO enfermeiroDTO = this.enfermeiroService.findById(id);
        return ResponseEntity.ok(enfermeiroDTO);
    }

    @PostMapping
    public ResponseEntity<EnfermeiroDTO> save(@RequestBody @Valid EnfermeiroDTO enfermeiroDTO) {
        enfermeiroDTO = this.enfermeiroService.save(enfermeiroDTO);
        return new ResponseEntity<>(enfermeiroDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnfermeiroDTO> update(@PathVariable UUID id, @RequestBody @Valid EnfermeiroDTO enfermeiroDTO) {
        enfermeiroDTO = this.enfermeiroService.update(id, enfermeiroDTO);
        return ResponseEntity.ok(enfermeiroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.enfermeiroService.delete(id);
    }
}
