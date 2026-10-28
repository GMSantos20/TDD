package com.exemplo.tdd;

import java.util.Map;

public class Carrinho {
    private static final int QUANTIDADE_MINIMA_DESCONTO = 5;
    private static final double PERCENTUAL_DESCONTO = 0.10;
    
    private static final Map<String, Double> CUPONS_ATIVOS = Map.of(
        "PROMO10", 0.10,
        "BLACKFRIDAY", 0.20
    );

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

    public void aplicarCupom(String codigo) {
        if (!CUPONS_ATIVOS.containsKey(codigo)) {
            throw new CupomInvalidoException("Cupom '" + codigo + "' é inválido ou expirou.");
        }
        double desconto = CUPONS_ATIVOS.get(codigo);
        this.total *= (1.0 - desconto);
    }

    public double obterTotal() {
        return Math.round(this.total * 100.0) / 100.0;
    }
}
