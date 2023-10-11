package br.com.ada.reactivejavaclientmanagement.service;

import br.com.ada.reactivejavaclientmanagement.converter.ClientConverter;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePJDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ResponseDTO;
import br.com.ada.reactivejavaclientmanagement.exception.ClientNaoEncontradoException;
import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import br.com.ada.reactivejavaclientmanagement.model.Juridica;
import br.com.ada.reactivejavaclientmanagement.repository.ClientPFRepository;
import br.com.ada.reactivejavaclientmanagement.repository.ClientPJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    public Optional<ResponseDTO> createPJ(Juridica juridica) throws Exception {
        Optional<Juridica> clientPJ = Optional.of(clientPJRepository.save(juridica));

        return Optional.of(clientPJ.map(client ->
                        new ResponseDTO("Cliente PJ cadastrado com sucesso",
                                clientConverter.toClientPJDTO(client),
                                LocalDateTime.now()))
                .orElseThrow(() ->new Exception("Erro ao cadastrar o Cliente")));
    }



    public Optional<List<Juridica>> getAllPJ() throws Exception {
        return Optional.ofNullable(Optional.of(clientPJRepository.findAll()).orElseThrow(() -> new Exception("Erro ao buscar lista de clientes!")));
    }

    public Optional<ResponseDTO> findById(String id){
        Optional<Juridica> cliente = clientPJRepository.findById(id);

        return Optional.ofNullable(cliente.map(juridica ->
                new ResponseDTO("Cliente encontrado!",
                        this.clientConverter.toClientPJDTO(juridica),
                        LocalDateTime.now())).orElseThrow(() -> new ClientNaoEncontradoException("Não encontrado cliente de ID " + id)));

    }

    public Optional<ResponseDTO> findByCnpj(String cnpj){
        Optional<Juridica> cliente = clientPJRepository.findByCnpj(cnpj);

        return Optional.ofNullable(cliente.map(juridica ->
                new ResponseDTO("Cliente encontrado!",
                        this.clientConverter.toClientPJDTO(juridica),
                        LocalDateTime.now())).orElseThrow(() -> new ClientNaoEncontradoException("Não encontrado cliente de cnpj " + cnpj)));

    }
    public Optional<ResponseDTO<ClientePJDTO>> update(Juridica juridica) throws Exception {
        Optional<Juridica> client = this.clientPJRepository.findById(String.valueOf(juridica.getIdentificacao()));
        return Optional.ofNullable(client.map(
                        (existingClient) -> {
                            return this.clientPJRepository.save(juridica);
                        })

                .map(
                        clienteSucesso ->
                                new ResponseDTO<>("Cliente alterado com sucesso!",
                                        this.clientConverter.toClientPJDTO(clienteSucesso),
                                        LocalDateTime.now()))
                .orElseThrow(() -> new Exception("Erro ao atualizar")));
    }

    public void delete(String id) {
         findById(id);
         this.clientPJRepository.deleteById(id);
    }
}
