package br.com.ada.reactivejavaclientmanagement.service;

import br.com.ada.reactivejavaclientmanagement.converter.ClientConverter;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePJDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ResponseDTO;
import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import br.com.ada.reactivejavaclientmanagement.model.Juridica;
import br.com.ada.reactivejavaclientmanagement.repository.ClientPFRepository;
import br.com.ada.reactivejavaclientmanagement.repository.ClientPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServicePJ {

    @Autowired
    private ClientConverter clientConverter;

    @Autowired
    private ClientPJRepository clientPJRepository;


    public Optional<ResponseDTO> createPJ(Juridica juridica){
        Optional<Juridica> clientPJ = Optional.of(clientPJRepository.save(juridica));

        return Optional.of(clientPJ.map(client ->
                        new ResponseDTO("Cliente PJ cadastrado com sucesso",
                                clientConverter.toClientPJDTO(client),
                                LocalDateTime.now()))
                .orElse(new ResponseDTO("Erro ao cadastrar o Cliente abaixo",
                        clientPJ,
                        LocalDateTime.now())));
    }



    public Optional<List<Juridica>> getAllPJ(){
        return Optional.of(clientPJRepository.findAll());
    }

    public Optional<ResponseDTO> findById(String id){
        Optional<Juridica> cliente = clientPJRepository.findById(id);

        return cliente.map(juridica ->
                new ResponseDTO("Cliente encontrado!",
                        this.clientConverter.toClientPJDTO(juridica),
                        LocalDateTime.now()));

    }
    public Optional<ResponseDTO<ClientePJDTO>> update(Juridica juridica) {
        Optional<Juridica> client = this.clientPJRepository.findById(String.valueOf(juridica.getIdentificacao()));
        return client.map(
                        (existingClient) ->{
                            return this.clientPJRepository.save(juridica);
                        })

                .map(
                        clienteSucesso ->
                                new ResponseDTO<>("Cliente alterado com sucesso!",
                                        this.clientConverter.toClientPJDTO(clienteSucesso),
                                        LocalDateTime.now()));
    }

    public void delete(String id) {
        this.clientPJRepository.deleteById(id);
    }
}
