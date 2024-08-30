package com.lojaeletronicos.modelo;

public class Vendedor extends Funcionario {

    public Vendedor(int matricula, String nome, String login, String senha) {
        super(matricula, nome, "Vendedor", login, senha);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Realizando vendas...");
    }
}
