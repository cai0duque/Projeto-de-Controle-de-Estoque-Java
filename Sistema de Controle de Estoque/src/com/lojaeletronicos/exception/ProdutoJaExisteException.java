package com.lojaeletronicos.exception;

public class ProdutoJaExisteException extends Exception {
    public ProdutoJaExisteException(String mensagem) {
        super(mensagem);
    }
}

