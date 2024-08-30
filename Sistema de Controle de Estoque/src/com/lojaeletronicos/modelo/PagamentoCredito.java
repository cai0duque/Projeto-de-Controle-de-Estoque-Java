package com.lojaeletronicos.modelo;

public class PagamentoCredito implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal * 1.05; // 5% de acréscimo
    }
}
