package br.com.api.sgv.entities;

import br.com.api.sgv.dto.PacienteDTO;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("P")
public class Paciente extends Usuario {
    @OneToOne
    @JoinColumn(name = "idCarteiraVacina", referencedColumnName = "id")
    private CarteiraVacina idCarteiraVacina;

    public Paciente() {

    }

    public Paciente(String nome, String email, String senha, String rg, LocalDate dataNascimento) {
        super.nome = nome;
        super.email = email;
        super.senha = senha;
        super.rg = rg;
        super.dataNascimento = dataNascimento;
    }

    public PacienteDTO toDto() {
        return new PacienteDTO(this.id, this.nome, this.email, this.senha, this.rg, this.dataNascimento);
    }
}
