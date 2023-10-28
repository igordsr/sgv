package br.com.api.sgv.entities;

import br.com.api.sgv.dto.VacinaDTO;
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

    public Vacina(){}

    public Vacina(UUID id, String nomeVacina, String doseVacina, int numeroLote, int quantidade) {
        this.id = id;
        this.nomeVacina = nomeVacina;
        this.doseVacina = doseVacina;
        this.numeroLote = numeroLote;
        this.quantidade = quantidade;
    }

    public VacinaDTO toDTO(){
        return new VacinaDTO(this.id,this.nomeVacina,this.doseVacina,this.numeroLote,this.quantidade);
    }


}


