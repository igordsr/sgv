package br.com.api.sgv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UnidadeDTO(
        UUID id,
        @NotBlank(message = "Nome da Unidade não pode estar em Branco.")
        String nome,
        @NotNull(message = "Resgistro da Unidade não pode estar em Branco.")
        Integer registroUnidade,
        @NotBlank(message = "Situação da Unidade não pode estar em Branco.")
        String situacao,
        @NotBlank(message = "As Vacinas não pode estar em Branco.")
        String vacinas
) {
}
