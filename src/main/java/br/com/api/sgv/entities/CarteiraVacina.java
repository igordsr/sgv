package br.com.api.sgv.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CarteiraVacina {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(nullable = false)
    private int numeroSus;

    @ManyToOne
    @JoinColumn(name = "vacina_aplicada_id", nullable = false)
    private VacinaAplicada vacinaAplicada;
}
