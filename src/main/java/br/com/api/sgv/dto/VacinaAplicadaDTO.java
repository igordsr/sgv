package br.com.api.sgv.dto;

import br.com.api.sgv.entities.VacinaAplicada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public record VacinaAplicadaDTO(
        UUID id,
        @NotNull(message = "Numero do SUS não pode estar em Branco.")
        BigInteger numeroSus,
        @NotNull(message = "Codigo da Vacina não pode ser nulo.")
        UUID vacinaId,
        @NotBlank(message = "Nome da Dose da vacina não pode estar em Branco.")
        String doseVacina,
        @NotNull(message = "Data da aplicação da vacina não pode ser nula.")
        LocalDate dataAplicacao
) {

}
