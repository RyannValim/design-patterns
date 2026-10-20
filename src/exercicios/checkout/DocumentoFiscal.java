package checkout;

public abstract class DocumentoFiscal implements ArtefatoCheckout{ // AbstractProductA
    public abstract void emitir(Pedido pedido);
    public abstract Double getValorImposto();
}
