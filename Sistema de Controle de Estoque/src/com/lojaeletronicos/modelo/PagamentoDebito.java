package com.lojaeletronicos.modelo;

public class PagamentoDebito implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal; // Valor integral, sem desconto ou acréscimo
    }
}
