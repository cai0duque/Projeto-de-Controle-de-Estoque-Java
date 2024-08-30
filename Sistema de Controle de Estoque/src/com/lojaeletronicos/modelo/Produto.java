package com.lojaeletronicos.modelo;

public abstract class Produto {
    private static int idCounter = 1;
    private final int id;
    private String codigoBarras;
    private String marca;
    private String modelo;
    private int quantidadeEstoque;
    private double precoCompra;
    private double precoVenda;

    public Produto(String codigoBarras, String marca, String modelo, int quantidadeEstoque, double precoCompra, double precoVenda) {
        this.id = idCounter++;
        this.codigoBarras = codigoBarras;
        this.marca = marca;
        this.modelo = modelo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public int getId() {
        return id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getLucroEstimado() {
        return precoVenda - precoCompra;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Código de Barras: " + codigoBarras + ", Marca: " + marca + ", Modelo: " + modelo +
                ", Estoque: " + quantidadeEstoque + ", Preço de Compra: " + precoCompra + ", Preço de Venda: " + precoVenda;
    }
}
