package br.com.api.sgv.dto;

import br.com.api.sgv.entities.Vacina;
import br.com.api.sgv.entities.VacinaAplicada;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record VacinaAplicadaDTO(
        UUID id,

        @NotNull(message = "vacina não pode ser nulo.")
        Vacina vacina,

        @NotBlank(message = "Nome da Vacina não pode estar em Branco.")
        String nomeVacina,
        @NotBlank(message = "Nome da Dose da vacina não pode estar em Branco.")
        String doseVacina,

        @NotNull(message = "Data da aplicação da vacina não pode ser nula.")
        LocalDate dataAplicacao,

        @NotNull(message = "Numero do lote da vacina não pode ser nulo.")
        int numeroLote
) {
    public VacinaAplicada toModel(){
        return new VacinaAplicada(this.id,this.vacina,this.nomeVacina,this.doseVacina,this.dataAplicacao,this.numeroLote);
    }
}
