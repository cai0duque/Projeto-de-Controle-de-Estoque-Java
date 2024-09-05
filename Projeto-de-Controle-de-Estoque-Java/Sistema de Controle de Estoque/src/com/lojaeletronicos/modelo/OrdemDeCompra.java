package com.lojaeletronicos.modelo;

import java.util.Date;

public abstract class OrdemDeCompra {
    private static int numeroOrdemCounter = 1;
    private final int numeroOrdem;
    private Date data;
    private Funcionario responsavel;
    private Produto produto;
    private int quantidade;

    public OrdemDeCompra(Date data, Funcionario responsavel, Produto produto, int quantidade) {
        this.numeroOrdem = numeroOrdemCounter++;
        this.data = data;
        this.responsavel = responsavel;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getNumeroOrdem() {
        return numeroOrdem;
    }

    public Date getData() {
        return data;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public abstract void processarOrdem();
}
