package br.com.api.sgv.dto;

import br.com.api.sgv.entities.Vacina;
import br.com.api.sgv.entities.VacinaAplicada;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record VacinaAplicadaDTO(
        UUID id,
        @NotBlank(message = "Vacina não pode estar em Branco.")
        Vacina vacina,

        @NotBlank(message = "Nome da Vacina não pode estar em Branco.")
        String nomeVacina,
        @NotBlank(message = "Nome da Dose da vacina não pode estar em Branco.")
        String doseVacina,

        @NotBlank(message = "Data da aplicação da vacina não pode estar em Branco.")
        LocalDate dataAplicacao,

        @NotBlank(message = "Numero do lote da vacina não pode estar em Branco.")
        int numeroLote
) {
    public VacinaAplicada toModel(){
        return new VacinaAplicada(this.id,this.vacina,this.nomeVacina,this.doseVacina,this.dataAplicacao,this.numeroLote);
    }
}
