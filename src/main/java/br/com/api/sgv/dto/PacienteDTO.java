package br.com.api.sgv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record PacienteDTO (
        UUID id,
        @NotBlank(message = "Nome do Paciente não pode estar em Branco.")
        String nome,
        @NotBlank(message = "Email do Paciente não pode estar em Branco.")
        String email,
        @NotBlank(message = "Senha do Paciente não pode estar em Branco.")
        String senha,
        @NotBlank(message = "Rg do Paciente não pode estar em Branco.")
        String rg,
        @NotNull(message = "Data de Nascimento do Paciente não pode estar em Branco.")
        LocalDate dataNascimento
) {
}
