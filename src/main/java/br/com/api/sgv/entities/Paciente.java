package br.com.api.sgv.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.UUID;

@Entity
@DiscriminatorValue("P")
public class Paciente extends Usuario {
    @OneToOne
    @JoinColumn(name = "idCarteiraVacina", referencedColumnName = "id")
    private CarteiraVacina idCarteiraVacina;
}
