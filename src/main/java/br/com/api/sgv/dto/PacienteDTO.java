package br.com.api.sgv.dto;

import br.com.api.sgv.entities.CarteiraVacina;
import br.com.api.sgv.entities.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public record PacienteDTO(
        UUID id,
        @NotNull(message = "Numero do SUS não pode estar em Branco.")
        BigInteger numeroSus,
        @NotBlank(message = "Nome do Paciente não pode estar em Branco.")
        String nome,
        @NotBlank(message = "Email do Paciente não pode estar em Branco.")
        String email,
        @NotBlank(message = "Senha do Paciente não pode estar em Branco.")
        String senha,
        @NotBlank(message = "Rg do Paciente não pode estar em Branco.")
        String rg,
        @NotNull(message = "Data de Nascimento do Paciente não pode estar em Branco.")
        LocalDate dataNascimento,
        CarteiraVacinaDTO carteiraVacina
) {
    public Paciente toModel() {
        return new Paciente(this.nome, this.email, this.senha, this.rg, this.dataNascimento, numeroSus);
    }
}
