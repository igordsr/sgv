package br.com.api.sgv.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class VacinaAplicada {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;

    @Column(nullable = false)
    private String nomeVacina;

    @Column(nullable = false)
    private String doseVacina;

    @Column(nullable = false)
    private LocalDate dataAplicacao;

    @Column(nullable = false)
    private int numeroLote;
}
