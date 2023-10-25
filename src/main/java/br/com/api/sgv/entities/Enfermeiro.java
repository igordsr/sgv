package br.com.api.sgv.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Enfermeiro {
    @Column(nullable = false)
    Integer numeroCoren;
}
