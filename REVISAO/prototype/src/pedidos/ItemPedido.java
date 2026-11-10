package pedidos;

import java.math.BigDecimal;

public class ItemPedido{
    private String produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    // constructor
    public ItemPedido(
        String produto, int quantidade, BigDecimal precoUnitario
    ){
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // clone constructor
    public ItemPedido(ItemPedido origem){
        this.produto = origem.produto;
        this.quantidade = origem.quantidade;
        this.precoUnitario = origem.precoUnitario;
    }

    public String getProduto(){ return this.produto; }
    
    public int getQuantidade(){ return this.quantidade; }
    public void setQuantidade(int quantidade){ this.quantidade = quantidade; }

    public BigDecimal getPrecoUnitario(){ return this.precoUnitario; }

    public BigDecimal subtotal(){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
