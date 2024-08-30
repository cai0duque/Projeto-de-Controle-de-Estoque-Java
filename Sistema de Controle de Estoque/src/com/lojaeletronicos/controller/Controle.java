package com.lojaeletronicos.controller;

import com.lojaeletronicos.exception.FuncionarioJaExisteException;
import com.lojaeletronicos.exception.ProdutoJaExisteException;
import com.lojaeletronicos.modelo.Funcionario;
import com.lojaeletronicos.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    private List<Produto> produtos;
    private List<Funcionario> funcionarios;

    public Controle() {
        produtos = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    // Gerenciamento de Produtos
    public void cadastrarProduto(Produto produto) throws ProdutoJaExisteException {
        Produto produtoExistente = procurarProdutoPorId(produto.getId());
        if (produtoExistente != null) {
            throw new ProdutoJaExisteException("Erro: Já existe um produto com o ID " + produto.getId() + " cadastrado.");
        }
        produtos.add(produto);
    }

    public Produto procurarProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void adicionarEstoque(int id, int quantidade) {
        Produto produto = procurarProdutoPorId(id);
        if (produto != null) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    // Gerenciamento de Funcionários
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException {
        Funcionario funcionarioExistente = procurarFuncionarioPorMatricula(funcionario.getMatricula());
        if (funcionarioExistente != null) {
            throw new FuncionarioJaExisteException("Erro: Já existe um funcionário com a matrícula " + funcionario.getMatricula() + " cadastrado.");
        }
        funcionarios.add(funcionario);
    }

    public Funcionario procurarFuncionarioPorMatricula(int matricula) {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula() == matricula) {
                return f;
            }
        }
        return null;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public void excluirFuncionario(int matricula) {
        Funcionario funcionario = procurarFuncionarioPorMatricula(matricula);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
        }
    }
}
