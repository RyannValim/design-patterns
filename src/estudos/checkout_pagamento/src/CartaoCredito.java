package estudos.checkout_pagamento.src;

public class CartaoCredito implements FormaPagamento, Reembolsavel{
    @Override
    public String processarPagamento(double valor){
        return "Pagamento via Cartão de Crédito realizado no valor de R$" + valor;
    }

    @Override
    public String estornar(double valor){
        return "O valor R$" + valor + " foi estornado para a conta!";
    }
}
