package br.com.api.sgv.entities;

import br.com.api.sgv.dto.VacinaAplicadaDTO;
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

    public VacinaAplicada() {
    }

    public VacinaAplicada(UUID id, Vacina vacina, String nomeVacina, String doseVacina, LocalDate dataAplicacao, int numeroLote) {
        this.id = id;
        this.vacina = vacina;
        this.nomeVacina = nomeVacina;
        this.doseVacina = doseVacina;
        this.dataAplicacao = dataAplicacao;
        this.numeroLote = numeroLote;
    }

    public VacinaAplicadaDTO toDTO(){
        return new VacinaAplicadaDTO(this.id,this.vacina,this.nomeVacina,this.doseVacina,this.dataAplicacao,this.numeroLote);
    }
}
