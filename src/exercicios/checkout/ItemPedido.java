package checkout;

public class ItemPedido{
    private String descricao;
    private Double valorUnitario;
    private int quantidade;
    private Boolean essencial;

    public ItemPedido(String descricao, Double valorUnitario, int quantidade, Boolean essencial){
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.essencial = essencial;
    }

    public Double getValorTotal(){ return this.valorUnitario * this.quantidade; }

    public String getDescricao(){ return this.descricao; }
    public int getQuantidade(){ return this.quantidade; }
    public Boolean isEssencial(){ return this.essencial; }
}
