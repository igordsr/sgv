package br.com.api.sgv.entities;

import br.com.api.sgv.dto.EnfermeiroDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Enfermeiro extends Usuario {
    @Column(nullable = false)
    Integer numeroCoren;

    public Enfermeiro(String nome, String email, String senha, String rg, LocalDate dataNascimento, Integer numeroCoren) {
        super.nome = nome;
        super.email = email;
        super.senha = senha;
        super.rg = rg;
        super. dataNascimento = dataNascimento;
        this.numeroCoren = numeroCoren;
    }

    public EnfermeiroDTO toDto() {
        return new EnfermeiroDTO(this.id, this.nome, this.email, this.senha, this.rg, this.dataNascimento, this.numeroCoren);
    }
}
