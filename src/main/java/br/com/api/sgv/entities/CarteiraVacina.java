package br.com.api.sgv.entities;

import br.com.api.sgv.dto.CarteiraVacinaDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CarteiraVacina {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;

    @Column(nullable = false)
    private BigInteger numeroSus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carteiraVacina")
    private List<VacinaAplicada> vacinaAplicadas = new ArrayList<>();

    public CarteiraVacina() {

    }

    public CarteiraVacina(Usuario usuario, BigInteger numeroSus) {
        this.usuario = usuario;
        this.numeroSus = numeroSus;
    }

    public CarteiraVacinaDTO toDTO() {
        return new CarteiraVacinaDTO(this.id, this.numeroSus, this.vacinaAplicadas.stream().map(VacinaAplicada::toRegistroDeVacinaDTO).collect(Collectors.toList()));
    }


}
