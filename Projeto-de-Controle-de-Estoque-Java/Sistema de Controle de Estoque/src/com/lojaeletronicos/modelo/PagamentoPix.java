package com.lojaeletronicos.modelo;

public class PagamentoPix implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal; // Valor integral
    }
}
