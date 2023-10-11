package br.com.ada.reactivejavaclientmanagement.exception;

import java.util.function.Supplier;

public class ClientNaoEncontradoException  extends RuntimeException {

    public ClientNaoEncontradoException(String message) {
        super(message);
    }
}

