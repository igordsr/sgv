package br.com.api.sgv.controller;

import br.com.api.sgv.dto.PacienteDTO;
import br.com.api.sgv.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable UUID id) {
        final PacienteDTO pacienteDTO = this.pacienteService.findById(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> save(@RequestBody @Valid PacienteDTO pacienteDTO) {
        pacienteDTO = this.pacienteService.save(pacienteDTO);
        return new ResponseEntity<>(pacienteDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> update(@PathVariable UUID id, @RequestBody @Valid PacienteDTO pacienteDTO) {
        pacienteDTO = this.pacienteService.update(id, pacienteDTO);
        return ResponseEntity.ok(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.pacienteService.delete(id);
    }
}
