package br.com.api.sgv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EnfermeiroDTO(
        UUID id,
        @NotBlank(message = "Nome do Enfermeiro não pode estar em Branco.")
        String nome,
        @NotBlank(message = "Email do Enfermeiro não pode estar em Branco.")
        String email,
        @NotBlank(message = "Senha do Enfermeiro não pode estar em Branco.")
        String senha,
        @NotBlank(message = "Rg do Enfermeiro não pode estar em Branco.")
        String rg,
        @NotNull(message = "Data do Nascimento do Enfermeiro não pode estar em Branco.")
        LocalDate dataNascimento,
        @NotNull(message = "Numero do Coren do Enfermeiro não pode estar em Branco.")
        Integer numeroCoren
) {
}
