package br.com.ada.reactivejavaclientmanagement.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Fisica extends Pessoa{

    private String nome;
    private String cpf;
}
