package br.com.api.sgv.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioDTO(
        UUID id,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        String nome,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        String email,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        String senha,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        String rg,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        LocalDate dataNascimento
) {
}
