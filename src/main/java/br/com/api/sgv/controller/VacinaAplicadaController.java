package br.com.api.sgv.controller;

import br.com.api.sgv.dto.VacinaAplicadaDTO;
import br.com.api.sgv.service.VacinaAplicadaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/vacinasAplicadas")
public class VacinaAplicadaController {
    @Autowired
    private VacinaAplicadaService vacinaAplicadaService;
    @GetMapping
    public ResponseEntity<List<VacinaAplicadaDTO>> findAll() {
        return ResponseEntity.ok(vacinaAplicadaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinaAplicadaDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(vacinaAplicadaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VacinaAplicadaDTO> save(@RequestBody @Valid VacinaAplicadaDTO vacinaAplicadaDTO) {
        return new ResponseEntity<>(vacinaAplicadaService.save(vacinaAplicadaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacinaAplicadaDTO> update(@PathVariable UUID id, @RequestBody @Valid VacinaAplicadaDTO vacinaAplicadaDTO) {
        return ResponseEntity.ok(vacinaAplicadaService.update(id, vacinaAplicadaDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.vacinaAplicadaService.delete(id);
    }
}