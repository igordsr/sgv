package br.com.api.sgv.controller;

import br.com.api.sgv.dto.VacinaDTO;
import br.com.api.sgv.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    @Autowired
    private VacinaService vacinaService;
    @GetMapping
    public ResponseEntity<List<VacinaDTO>> findAll() {
        return ResponseEntity.ok(vacinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinaDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(vacinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VacinaDTO> save(@RequestBody @Valid VacinaDTO vacinaDTO) {
        return new ResponseEntity<>(vacinaService.save(vacinaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacinaDTO> update(@PathVariable UUID id, @RequestBody @Valid VacinaDTO vacinaDTO) {
        return ResponseEntity.ok(vacinaService.update(id, vacinaDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.vacinaService.delete(id);
    }
}
