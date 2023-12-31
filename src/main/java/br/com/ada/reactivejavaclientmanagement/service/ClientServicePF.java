package br.com.ada.reactivejavaclientmanagement.service;

import br.com.ada.reactivejavaclientmanagement.converter.ClientConverter;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ResponseDTO;
import br.com.ada.reactivejavaclientmanagement.exception.ClientNaoEncontradoException;
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
public class ClientServicePF {

    @Autowired
    private ClientConverter clientConverter;

    @Autowired
    private ClientPFRepository clientPFRepository;


    public Optional<ResponseDTO> createPF(Fisica fisica){
        Optional<Fisica> clientPF = Optional.of(clientPFRepository.save(fisica));

        return Optional.of(clientPF.map(client ->
                        new ResponseDTO("Cliente PF cadastrado com sucesso",
                                clientConverter.toClientPFDTO(client),
                                LocalDateTime.now()))
                .orElse(new ResponseDTO("Erro ao cadastrar o Cliente PF abaixo",
                        fisica,
                        LocalDateTime.now())));
    }

    public Optional<List<Fisica>> getAllPF() throws Exception {
        return Optional.ofNullable(Optional.of(clientPFRepository.findAll()).orElseThrow(() -> new Exception("Erro ao buscar lista de clientes!")));
    }


    public Optional<ResponseDTO> findById(String id){
        Optional<Fisica> cliente = clientPFRepository.findById(id);

        return Optional.ofNullable(cliente.map(fisica ->
                new ResponseDTO("Cliente encontrado!",
                        this.clientConverter.toClientPFDTO(fisica),
                        LocalDateTime.now())).orElseThrow(() -> new ClientNaoEncontradoException("Não encontrado cliente de ID " + id)));

    }

    public Optional<ResponseDTO> findByCpf(String cpf){
        Optional<Fisica> cliente = clientPFRepository.findByCpf(cpf);

        return Optional.ofNullable(cliente.map(fisica ->
                new ResponseDTO("Cliente encontrado!",
                        this.clientConverter.toClientPFDTO(fisica),
                        LocalDateTime.now())).orElseThrow(() -> new ClientNaoEncontradoException("Não encontrado cliente de cpf " + cpf)));

    }

    public Optional<ResponseDTO<ClientePFDTO>> update(Fisica fisica) throws Exception {
        Optional<Fisica> client = this.clientPFRepository.findById(String.valueOf(fisica.getIdentificacao()));
        return Optional.ofNullable(client.map(
                        (existingClient) -> {
                            return this.clientPFRepository.save(fisica);
                        })

                .map(
                        clienteSucesso ->
                                new ResponseDTO<>("Cliente alterado com sucesso!",
                                        this.clientConverter.toClientPFDTO(clienteSucesso),
                                        LocalDateTime.now())).orElseThrow(() -> new Exception("Erro ao atualizar")));
    }

    public void delete(String id) {
        findById(id);
        this.clientPFRepository.deleteById(id);
    }
}
