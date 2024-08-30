package com.lojaeletronicos.exception;

public class FuncionarioJaExisteException extends Exception {
    public FuncionarioJaExisteException(String mensagem) {
        super(mensagem);
    }
}
