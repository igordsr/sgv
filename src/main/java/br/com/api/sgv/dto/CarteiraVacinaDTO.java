package br.com.api.sgv.dto;

import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.entities.Usuario;
import br.com.api.sgv.entities.VacinaAplicada;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public record CarteiraVacinaDTO(
        UUID id,
        @NotBlank(message = "Numero do SUS não pode estar em Branco.")
        BigInteger numeroSus,
        @NotNull
        List<RegistroDeVacinaDTO> vacinaAplicada
) {

}
