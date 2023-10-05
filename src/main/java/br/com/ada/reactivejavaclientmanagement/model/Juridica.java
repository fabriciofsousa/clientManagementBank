package br.com.ada.reactivejavaclientmanagement.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Juridica extends Pessoa{
    private String nome;
    private String cnpj;
}
