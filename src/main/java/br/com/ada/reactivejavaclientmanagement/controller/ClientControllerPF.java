package br.com.ada.reactivejavaclientmanagement.controller;

import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ClientePJDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ResponseDTO;
import br.com.ada.reactivejavaclientmanagement.model.Fisica;
import br.com.ada.reactivejavaclientmanagement.model.Juridica;
import br.com.ada.reactivejavaclientmanagement.service.ClientServicePF;
import br.com.ada.reactivejavaclientmanagement.service.ClientServicePJ;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pf")
@AllArgsConstructor
public class ClientControllerPF {

    private ClientServicePF clientServicePF;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Create a client (Pessoa Fisica)",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    public Optional<ResponseDTO> create(@RequestBody Fisica fisica){
        return clientServicePF.createPF(fisica);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Find all clients PF")
    public Optional<List<Fisica>> getAll(){
        return clientServicePF.getAllPF();
    }


    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Get client PF by id")
    public Optional<ResponseDTO> findById(@PathVariable("id") String code){
        return clientServicePF.findById(code);
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Update a client PF")
    public Optional<ResponseDTO<ClientePFDTO>> update(@RequestBody Fisica clientDTO){
        return this.clientServicePF.update(clientDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        this.clientServicePF.delete(id);
        return ResponseEntity.noContent().build();
    }


}
