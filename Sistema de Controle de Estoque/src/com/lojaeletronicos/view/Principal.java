package com.lojaeletronicos.view;

import com.lojaeletronicos.controller.Controle;
import com.lojaeletronicos.exception.FuncionarioJaExisteException;
import com.lojaeletronicos.exception.ProdutoJaExisteException;
import com.lojaeletronicos.modelo.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Controle controle = new Controle();
        Scanner scanner = new Scanner(System.in);

        // Exemplo de login (apenas para gerente)
        System.out.println("Seja bem-vindo. Insira seu login:");
        System.out.print("Nome: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Simulação de login
        Gerente gerente = new Gerente(1, "Gerente", login, senha); // matrícula manual para gerente

        // Menu principal
        int opcao = 0;
        do {
            System.out.println("Menu principal:");
            System.out.println("1. ESTOQUE");
            System.out.println("2. FUNCIONÁRIOS");
            System.out.println("3. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuEstoque(controle, scanner);
                    break;
                case 2:
                    menuFuncionarios(controle, scanner);
                    break;
                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void menuEstoque(Controle controle, Scanner scanner) {
        int opcao;
        do {
            System.out.println("ESTOQUE:");
            System.out.println("1. Verificar estoque em sua totalidade");
            System.out.println("2. Verificar tipos específicos de produto");
            System.out.println("3. Procurar produto por ID");
            System.out.println("4. Cadastrar produto");
            System.out.println("5. Adicionar estoque");
            System.out.println("6. Criar ordem de compra");
            System.out.println("7. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarProdutos(controle);
                    break;
                case 2:
                    listarTiposEspecificosDeProdutos(controle, scanner);
                    break;
                case 3:
                    procurarProdutoPorId(controle, scanner);
                    break;
                case 4:
                    cadastrarProduto(controle, scanner);
                    break;
                case 5:
                    adicionarEstoque(controle, scanner);
                    break;
                case 6:
                    System.out.println("Criar ordem de compra: (implementação futura)");
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    private static void menuFuncionarios(Controle controle, Scanner scanner) {
        int opcao;
        do {
            System.out.println("FUNCIONÁRIOS:");
            System.out.println("1. Verificar total de funcionários");
            System.out.println("2. Procurar funcionário por matrícula");
            System.out.println("3. Cadastrar funcionário");
            System.out.println("4. Excluir funcionário");
            System.out.println("5. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarFuncionarios(controle);
                    break;
                case 2:
                    procurarFuncionarioPorMatricula(controle, scanner);
                    break;
                case 3:
                    cadastrarFuncionario(controle, scanner);
                    break;
                case 4:
                    excluirFuncionario(controle, scanner);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void listarProdutos(Controle controle) {
        System.out.println("Produtos cadastrados:");
        for (Produto produto : controle.listarProdutos()) {
            System.out.println(produto);
        }
    }

    private static void listarTiposEspecificosDeProdutos(Controle controle, Scanner scanner) {
        System.out.println("Verificar tipos específicos de produto:");
        System.out.println("1. Lista de computadores");
        System.out.println("2. Lista de celulares");
        System.out.println("3. Lista de periféricos");
        System.out.println("4. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        String tipo = "";

        switch (opcao) {
            case 1:
                tipo = "Computador";
                break;
            case 2:
                tipo = "Celular";
                break;
            case 3:
                tipo = "Periférico";
                break;
            case 4:
                System.out.println("Voltando...");
                return;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.println("Produtos do tipo " + tipo + ":");
        for (Produto produto : controle.listarProdutos()) {
            if (produto.getTipo().equals(tipo)) {
                System.out.println(produto);
            }
        }
    }

    private static void procurarProdutoPorId(Controle controle, Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Produto produto = controle.procurarProdutoPorId(id);
        if (produto != null) {
            System.out.println("Produto encontrado: " + produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void cadastrarProduto(Controle controle, Scanner scanner) {
        try {
            System.out.print("Digite o ID do produto: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Qual tipo de produto?");
            System.out.println("1. Computador");
            System.out.println("2. Celular");
            System.out.println("3. Periférico");
            int tipoProduto = scanner.nextInt();
            scanner.nextLine();
            String tipo = "";

            switch (tipoProduto) {
                case 1:
                    tipo = "Computador";
                    break;
                case 2:
                    tipo = "Celular";
                    break;
                case 3:
                    tipo = "Periférico";
                    break;
                default:
                    System.out.println("Tipo de produto inválido.");
                    return;
            }

            System.out.print("Digite o código de barras do produto: ");
            String codigoBarras = scanner.nextLine();
            System.out.print("Digite a marca do produto: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o modelo do produto: ");
            String modelo = scanner.nextLine();
            System.out.print("Digite a quantidade em estoque: ");
            int quantidadeEstoque = scanner.nextInt();
            System.out.print("Digite o preço de compra: ");
            double precoCompra = scanner.nextDouble();
            System.out.print("Digite o preço de venda: ");
            double precoVenda = scanner.nextDouble();
            scanner.nextLine();

            Produto produto = new Produto(id, tipo, codigoBarras, marca, modelo, quantidadeEstoque, precoCompra, precoVenda);
            controle.cadastrarProduto(produto);

            System.out.println("Produto cadastrado com sucesso!");
        } catch (ProdutoJaExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private static void adicionarEstoque(Controle controle, Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();
        System.out.print("Digite a quantidade a adicionar: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        controle.adicionarEstoque(id, quantidade);
        System.out.println("Estoque atualizado com sucesso.");
    }

    private static void listarFuncionarios(Controle controle) {
        System.out.println("Funcionários cadastrados:");
        for (Funcionario funcionario : controle.listarFuncionarios()) {
            System.out.println(funcionario);
        }
    }

    private static void procurarFuncionarioPorMatricula(Controle controle, Scanner scanner) {
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        Funcionario funcionario = controle.procurarFuncionarioPorMatricula(matricula);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado: " + funcionario);
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void cadastrarFuncionario(Controle controle, Scanner scanner) {
        try {
            System.out.print("Digite a matrícula do funcionário: ");
            int matricula = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o cargo (Gerente, Vendedor, Almoxarifado): ");
            String cargo = scanner.nextLine();
            System.out.print("Digite o login: ");
            String login = scanner.nextLine();
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            Funcionario funcionario;
            switch (cargo.toLowerCase()) {
                case "gerente":
                    funcionario = new Gerente(matricula, nome, login, senha);
                    break;
                case "vendedor":
                    funcionario = new Vendedor(matricula, nome, login, senha);
                    break;
                case "almoxarifado":
                    funcionario = new FuncionarioAlmoxarifado(matricula, nome, login, senha);
                    break;
                default:
                    System.out.println("Cargo inválido.");
                    return;
            }

            controle.cadastrarFuncionario(funcionario);
            System.out.println("Funcionário cadastrado com sucesso!");
        } catch (FuncionarioJaExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    private static void excluirFuncionario(Controle controle, Scanner scanner) {
        System.out.print("Digite a matrícula do funcionário a ser excluído: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        controle.excluirFuncionario(matricula);
        System.out.println("Funcionário excluído com sucesso.");
    }
}
