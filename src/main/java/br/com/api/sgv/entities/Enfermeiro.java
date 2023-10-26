package br.com.api.sgv.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Enfermeiro extends Usuario {
    @Column(nullable = false)
    private Integer numeroCoren;
}
