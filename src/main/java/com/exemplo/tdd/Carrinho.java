package com.exemplo.tdd;

public class Carrinho {
    private static final int QUANTIDADE_MINIMA_DESCONTO = 5;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    private double total = 0.0;

    public void adicionarItem(double precoUnitario, int quantidade) {
        double precoFinal = calcularPrecoUnitario(precoUnitario, quantidade);
        this.total += precoFinal * quantidade;
    }

    private double calcularPrecoUnitario(double preco, int qtd) {
        if (qtd >= QUANTIDADE_MINIMA_DESCONTO) {
            return preco * (1.0 - PERCENTUAL_DESCONTO);
        }
        return preco;
    }

    public void aplicarCupom(String cupom) {
        if ("INVALIDO".equals(cupom)) {
            throw new CupomInvalidoException("Cupom inválido: " + cupom);
        }
    }

    public double obterTotal() {
        return this.total;
    }
}
