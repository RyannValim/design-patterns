package checkout;

public abstract class ProcessadorPagamento implements ArtefatoCheckout{ // AbstractProductB
    public abstract void processar(Pedido pedido, Double valorTotal);
}
