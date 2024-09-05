package com.lojaeletronicos.modelo;

public class Gerente extends Funcionario {

    public Gerente(int matricula, String nome, String login, String senha) {
        super(matricula, nome, "Gerente", login, senha);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Gerenciando o sistema...");
    }
}
