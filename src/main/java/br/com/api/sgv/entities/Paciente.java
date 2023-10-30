package br.com.api.sgv.entities;

import br.com.api.sgv.dto.PacienteDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@DiscriminatorValue("P")
public class Paciente extends Usuario {
    @OneToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "idCarteiraVacina", referencedColumnName = "id")
    @JsonBackReference
    private CarteiraVacina carteiraVacina;

    public Paciente() {

    }

    public Paciente(String nome, String email, String senha, String rg, LocalDate dataNascimento, BigInteger numeroSus) {
        super.nome = nome;
        super.email = email;
        super.senha = senha;
        super.rg = rg;
        super.dataNascimento = dataNascimento;
        this.carteiraVacina = new CarteiraVacina(this, numeroSus);
    }

    public PacienteDTO toDto() {
        return new PacienteDTO(this.id, this.carteiraVacina.getNumeroSus(), this.nome, this.email, this.senha, this.rg, dataNascimento, this.carteiraVacina.toDTO());
    }
}
