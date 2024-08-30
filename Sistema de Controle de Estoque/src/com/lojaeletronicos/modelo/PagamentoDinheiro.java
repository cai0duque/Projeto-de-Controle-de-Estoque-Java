package com.lojaeletronicos.modelo;

public class PagamentoDinheiro implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal * 0.9; // 10% de desconto
    }
}

public class PagamentoDebito implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal; // Valor integral
    }
}

public class PagamentoCredito implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal * 1.05; // 5% de acréscimo
    }
}

public class PagamentoPix implements Pagamento {

    @Override
    public double calcularValor(double valorOriginal) {
        return valorOriginal; // Valor integral
    }
}
