package br.com.api.sgv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public record RegistroDeVacinaDTO(
        UUID id,
        UUID vacinaId,
        String nomeVacina,
        String doseVacina,
        LocalDate dataAplicacao
) {

}
