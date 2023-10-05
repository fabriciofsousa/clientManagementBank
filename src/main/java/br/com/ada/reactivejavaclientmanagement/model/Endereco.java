package br.com.ada.reactivejavaclientmanagement.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Endereco {
    private String logradouro;
    private String numero;
    private String cidade;
    private String cep;
    private String endereco;
}
