package br.com.ada.reactivejavaclientmanagement.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Pessoa {

    private Long identificacao;
    private String telefone;
    private String nacionalidade;
    private Endereco endereco;

}
