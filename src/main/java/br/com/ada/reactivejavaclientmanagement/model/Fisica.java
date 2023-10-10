package br.com.ada.reactivejavaclientmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Fisica extends Pessoa{

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    public Fisica(String telefone, String nacionalidade, Endereco endereco, String nome, String cpf) {
        super(telefone, nacionalidade, endereco);
        this.nome = nome;
        this.cpf = cpf;
    }
}
