package com.lojaeletronicos.modelo;

public class FuncionarioAlmoxarifado extends Funcionario {

    public FuncionarioAlmoxarifado(int matricula, String nome, String login, String senha) {
        super(matricula, nome, "Almoxarifado", login, senha);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Gerenciando estoque...");
    }
}
