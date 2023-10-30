package br.com.api.sgv.entities;

import br.com.api.sgv.dto.RegistroDeVacinaDTO;
import br.com.api.sgv.dto.VacinaAplicadaDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class VacinaAplicada {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "carteira_vacina_id")
    private CarteiraVacina carteiraVacina;

    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;

    @Column(nullable = false)
    private String doseVacina;

    @Column(nullable = false)
    private LocalDate dataAplicacao;


    public VacinaAplicada() {

    }

    public VacinaAplicada(CarteiraVacina carteiraVacina, Vacina vacina, String doseVacina, LocalDate dataAplicacao) {
        this.carteiraVacina = carteiraVacina;
        this.vacina = vacina;
        this.doseVacina = doseVacina;
        this.dataAplicacao = dataAplicacao;
    }

    public VacinaAplicadaDTO toDTO(){
        return new VacinaAplicadaDTO(this.id, this.carteiraVacina.getNumeroSus(), this.vacina.getId(), this.doseVacina, this.dataAplicacao);
    }

    public RegistroDeVacinaDTO toRegistroDeVacinaDTO(){
        return new RegistroDeVacinaDTO(this.id, this.vacina.getId(), this.vacina.getNomeVacina(), this.doseVacina, this.dataAplicacao);
    }
}
