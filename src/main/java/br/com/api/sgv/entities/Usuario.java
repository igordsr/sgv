package br.com.api.sgv.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@Entity(name="usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    @Column(nullable = false)
    protected String nome;
    @Email
    @Column(nullable = false)
    protected String email;
    @Column(nullable = false)
    protected String senha;
    @Column(nullable = false)
    protected String rg;
    @Column(nullable = false)
    protected LocalDate dataNascimento;

}
