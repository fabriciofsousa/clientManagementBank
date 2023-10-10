package br.com.ada.reactivejavaclientmanagement.controller;

import br.com.ada.reactivejavaclientmanagement.dto.ClientePFDTO;
import br.com.ada.reactivejavaclientmanagement.dto.ResponseDTO;
import br.com.ada.reactivejavaclientmanagement.model.Fisica;
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
@RequestMapping
@AllArgsConstructor
public class ClientControllerPFePJ {

    private ClientServicePF clientServicePF;

    private ClientServicePJ clientServicePJ;


    @GetMapping("{numeroDeDocumento}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(description = "Get client PF by numeroDeDocumento")
    public Optional<ResponseDTO> findById(@PathVariable("numeroDeDocumento")
                                              String numeroDeDocumento) {
        if (numeroDeDocumento.length() == 11) {
            return clientServicePF.findByCpf(numeroDeDocumento);
        } else if (numeroDeDocumento.length() == 14) {
            return clientServicePJ.findByCnpj(numeroDeDocumento);
        }
    return null;

}

}
