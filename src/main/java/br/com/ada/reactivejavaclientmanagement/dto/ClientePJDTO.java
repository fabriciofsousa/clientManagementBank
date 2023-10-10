package br.com.ada.reactivejavaclientmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientePJDTO {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("nacionalidade")
    private String nacionalidade;

    @JsonProperty("endereco")
    private EnderecoDTO endereco;
}
