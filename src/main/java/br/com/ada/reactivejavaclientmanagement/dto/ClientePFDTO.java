package br.com.ada.reactivejavaclientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class ClientePFDTO {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("endereco")
    private EnderecoDTO endereco;
}
