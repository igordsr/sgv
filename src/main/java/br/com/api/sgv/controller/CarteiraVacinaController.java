package br.com.api.sgv.controller;

import br.com.api.sgv.dto.CarteiraVacinaDTO;
import br.com.api.sgv.service.CarteiraVacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carteira-vacinas")
public class CarteiraVacinaController {
    @Autowired
    private CarteiraVacinaService carteiraVacinaService;
    @GetMapping
    public ResponseEntity<List<CarteiraVacinaDTO>> findAll() {
        return ResponseEntity.ok(carteiraVacinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteiraVacinaDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(carteiraVacinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CarteiraVacinaDTO> save(@RequestBody @Valid CarteiraVacinaDTO carteiraVacinaDTO) {
        return new ResponseEntity<>(carteiraVacinaService.save(carteiraVacinaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarteiraVacinaDTO> update(@PathVariable UUID id, @RequestBody @Valid CarteiraVacinaDTO carteiraVacinaDTO) {
        return ResponseEntity.ok(carteiraVacinaService.update(id, carteiraVacinaDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.carteiraVacinaService.delete(id);
    }
}
