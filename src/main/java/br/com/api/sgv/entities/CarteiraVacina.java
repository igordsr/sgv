package br.com.api.sgv.entities;

import br.com.api.sgv.dto.CarteiraVacinaDTO;
import br.com.api.sgv.dto.VacinaDTO;
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

    public CarteiraVacina(){
    }
    public CarteiraVacina(UUID id, Usuario usuario, int numeroSus, VacinaAplicada vacinaAplicada) {
        this.id = id;
        this.usuario = usuario;
        this.numeroSus = numeroSus;
        this.vacinaAplicada = vacinaAplicada;
    }

    public CarteiraVacinaDTO toDTO(){
        return new CarteiraVacinaDTO(this.id,this.usuario,this.numeroSus,this.vacinaAplicada);
    }


}
