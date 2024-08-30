package com.lojaeletronicos.modelo;

public abstract class Funcionario {
    private static int matriculaCounter = 1;
    private final int matricula;
    private String nome;
    private String cargo;
    private String login;
    private String senha;

    public Funcionario(String nome, String cargo, String login, String senha) {
        this.matricula = matriculaCounter++;
        this.nome = nome;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Nome: " + nome + ", Cargo: " + cargo;
    }

    public abstract void executarTarefa();
}
