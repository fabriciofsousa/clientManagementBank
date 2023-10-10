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
@RequestMapping("/pj")
@AllArgsConstructor
public class ClientControllerPJ {


    private ClientServicePJ clientServicePJ;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(description = "Create a client (Pessoa Juridica)",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody())
    public Optional<ResponseDTO> createPj(@RequestBody Juridica juridica){
        return clientServicePJ.createPJ(juridica);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Find all clients PJ")
    public Optional<List<Juridica>> getAllPJ(){
        return clientServicePJ.getAllPJ();
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Get client PF by id")
    public Optional<ResponseDTO> findByIdPJ(@PathVariable("id") String code){
        return clientServicePJ.findById(code);
    }


    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Update a client PJ")
    public Optional<ResponseDTO<ClientePJDTO>> update(@RequestBody Juridica clientDTO){
        return this.clientServicePJ.update(clientDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePJ(@PathVariable("id") String id) {
        this.clientServicePJ.delete(id);
        return ResponseEntity.noContent().build();
    }

}
