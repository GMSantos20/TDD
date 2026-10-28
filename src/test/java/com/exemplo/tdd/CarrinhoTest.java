package com.exemplo.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarrinhoTest {

    @Test
    void deveAplicarDescontoDe10PorCentoQuandoQuantidadeMaiorOuIgualA5() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarItem(100.0, 5);

        // Esperado: (100.0 * 0.90) * 5 = 450.0
        assertEquals(450.0, carrinho.obterTotal(), 0.001);
    }
}

