package br.com.api.sgv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "unidade")
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer registroUnidade;
    @Column(nullable = false)
    private String situacao;
    @Column(nullable = false)
    private String vacinas;

}
