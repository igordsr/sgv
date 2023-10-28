package br.com.api.sgv.dto;

import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.entities.Usuario;
import br.com.api.sgv.entities.VacinaAplicada;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CarteiraVacinaDTO(
        UUID id,
        @NotBlank(message = "Usuario não pode estar em Branco.")
        Usuario usuario,

        @NotBlank(message = "Numero do SUS não pode estar em Branco.")
        int numeroSus,

        @NotBlank(message = "Vacina aplicada não pode estar em Branco.")
        VacinaAplicada vacinaAplicada
) {
    public CarteiraVacina toModel(){
        return new CarteiraVacina(this.id,this.usuario,this.numeroSus,this.vacinaAplicada);
    }
}
