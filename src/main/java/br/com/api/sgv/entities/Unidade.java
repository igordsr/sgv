package br.com.api.sgv.entities;

import br.com.api.sgv.dto.UnidadeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "unidade")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, name = "registro_unidade")
    private Integer registroUnidade;
    @Column(nullable = false)
    private String situacao;
    @Column(nullable = false)
    private String vacinas;

    public Unidade() {

    }

    public Unidade(String nome, Integer registroUnidade, String situacao, String vacinas) {
        this.nome = nome;
        this.registroUnidade = registroUnidade;
        this.situacao = situacao;
        this.vacinas = vacinas;
    }

    public UnidadeDTO toDto() {
        return new UnidadeDTO(this.id, this.nome, this.registroUnidade, this.situacao, this.vacinas);
    }
}
