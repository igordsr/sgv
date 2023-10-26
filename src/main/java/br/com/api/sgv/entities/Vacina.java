package br.com.api.sgv.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Vacina {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nomeVacina;

    @Column(nullable = false)
    private String doseVacina;

    @Column(nullable = false)
    private int numeroLote;

    @Column(nullable = false)
    private int quantidade;
}
