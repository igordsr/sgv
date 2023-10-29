package br.com.api.sgv.dto;

import br.com.api.sgv.entities.Vacina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VacinaDTO(
        UUID id,
        @NotBlank(message = "Nome da Vacina não pode estar em Branco.")
        String nomeVacina,
        @NotBlank(message = "Nome da Dose da vacina não pode estar em Branco.")
        String doseVacina,
        @NotNull(message = "Numero do lote da vacina não pode estar nulo.")
        int numeroLote,

        @NotNull(message = "Quantidade da vacina não pode estar nulo")
        int quantidade
)

{
        public Vacina toModel(){
                return new Vacina(this.id,this.nomeVacina,this.doseVacina,this.numeroLote,this.quantidade);
        }

}