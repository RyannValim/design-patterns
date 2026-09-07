package estudos.checkout_pagamento.src;

public class Boleto implements FormaPagamento{
    @Override
    public String processarPagamento(double valor){
        return "Pagamento via Boleto realizado no valor de R$" + valor;
    }
}
