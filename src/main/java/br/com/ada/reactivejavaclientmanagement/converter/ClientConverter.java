package br.com.ada.reactivejavaclientmanagement.converter;

import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePJDTO;
import br.com.ada.reactivejavaclientmanagement.dto.EnderecoDTO;
import br.com.ada.reactivejavaclientmanagement.model.Endereco;
import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import br.com.ada.reactivejavaclientmanagement.model.Juridica;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter {

    public ClientePFDTO toClientPFDTO(Fisica client) {
        return new ClientePFDTO(client.getNome(), client.getCpf(), client.getTelefone()
                , client.getNacionalidade(), new EnderecoDTO(client.getEndereco().getLogradouro(),
                client.getEndereco().getNumero(), client.getEndereco().getCidade(), client.getEndereco().getEstado(), client.getEndereco().getCep(), client.getEndereco().getEndereco()));
    }


    public Fisica toFisica(ClientePFDTO client) {
        return new Fisica(client.getTelefone()
                , client.getNacionalidade(), new Endereco(client.getEndereco().getLogradouro(),
                client.getEndereco().getNumero(), client.getEndereco().getCidade(),
                client.getEndereco().getEstado(), client.getEndereco().getCep(),
                client.getEndereco().getEndereco()),
                client.getNome(), client.getCpf());
    }

    public ClientePJDTO toClientPJDTO(Juridica client) {
        return new ClientePJDTO(client.getNome(), client.getCnpj(), client.getTelefone()
                , client.getNacionalidade(), new EnderecoDTO(client.getEndereco().getLogradouro(),
                client.getEndereco().getNumero(), client.getEndereco().getCidade(),
                client.getEndereco().getEstado(), client.getEndereco().getCep(),
                client.getEndereco().getEndereco()));
    }

    public Juridica toJuridica(ClientePJDTO client) {
        return new Juridica(client.getTelefone(), client.getNacionalidade()
                , new Endereco(client.getEndereco().getLogradouro(),
                client.getEndereco().getNumero(),
                client.getEndereco().getCidade(),
                client.getEndereco().getEstado(),
                client.getEndereco().getCep(),
                client.getEndereco().getEndereco()),
                client.getNome(), client.getCnpj());
    }
}
