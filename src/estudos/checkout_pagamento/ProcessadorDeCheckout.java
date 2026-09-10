package estudos.checkout_pagamento.src;

public class ProcessadorDeCheckout{
    public void finalizarPagamento(FormaPagamento forma, double valor){
        System.out.println(forma.processarPagamento(valor));
    }
}
