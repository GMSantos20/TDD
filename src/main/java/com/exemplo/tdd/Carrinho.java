package com.exemplo.tdd;

public class Carrinho {
    private double total = 0.0;

    public void adicionarItem(double precoUnitario, int quantidade) {
        if (quantidade >= 5) {
            precoUnitario *= 0.90;
        }
        this.total += precoUnitario * quantidade;
    }

    public double obterTotal() {
        return this.total;
    }
}

