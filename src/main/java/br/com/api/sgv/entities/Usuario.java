package br.com.api.sgv.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name="usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String tipoUsuario;
    @Column(nullable = false)
    private String rg;
    @Column(nullable = false)
    private LocalDate dataNascimento;

}
