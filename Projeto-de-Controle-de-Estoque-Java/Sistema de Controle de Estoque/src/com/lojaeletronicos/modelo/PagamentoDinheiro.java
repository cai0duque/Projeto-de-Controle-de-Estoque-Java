package com.lojaeletronicos.modelo;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal * 0.9; // 10% de desconto
    }
}

