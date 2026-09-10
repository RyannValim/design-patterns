package estudos.checkout_pagamento.src;

public class Pix implements FormaPagamento{
    @Override
    public String processarPagamento(double valor){
        return "Pagamento via PIX realizado no valor de R$" + valor;
    }
}
