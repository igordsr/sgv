package br.com.api.sgv.dto;

import br.com.api.sgv.entities.Vacina;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record VacinaDTO(
        UUID id,
        @NotBlank(message = "Nome da Vacina não pode estar em Branco.")
        String nomeVacina,
        @NotBlank(message = "Nome da Dose da vacina não pode estar em Branco.")
        String doseVacina,
        @NotBlank(message = "Numero do lote da vacina não pode estar em Branco.")
        int numeroLote,

        @NotBlank(message = "Quantidade da vacina não pode estar em Branco.")
        int quantidade
)

{
        public Vacina toModel(){
                return new Vacina(this.id,this.nomeVacina,this.doseVacina,this.numeroLote,this.quantidade);
        }

}