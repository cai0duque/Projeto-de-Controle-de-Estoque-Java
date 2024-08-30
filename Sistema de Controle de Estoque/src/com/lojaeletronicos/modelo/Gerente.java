package com.lojaeletronicos.modelo;

public class Gerente extends Funcionario {

    public Gerente(String nome, String login, String senha) {
        super(nome, "Gerente", login, senha);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Gerenciando o sistema...");
    }

    public void criarOrdemDeCompra() {
        System.out.println("Ordem de compra criada.");
    }
}
