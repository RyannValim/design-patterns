package checkout;

import java.util.List;

public class Pedido{
    private String numero;
    private String cliente;
    private String endereco;
    private String regiao; // UF, estado americano ou Bundesland
    private String codigoPostal;
    private List<ItemPedido> itens;

    public Pedido(String numero, String cliente, String endereco, String regiao, String codigoPostal, List<ItemPedido> itens){
        this.numero = numero;
        this.cliente = cliente;
        this.endereco = endereco;
        this.regiao = regiao;
        this.codigoPostal = codigoPostal;
        this.itens = itens;
    }

    public Double getSubtotal(){
        Double subtotal = 0.0;

        for(ItemPedido item : this.itens){ subtotal += item.getValorTotal(); }

        return subtotal;
    }

    public String getNumero(){ return this.numero; }
    public String getCliente(){ return this.cliente; }
    public String getEndereco(){ return this.endereco; }
    public String getRegiao(){ return this.regiao; }
    public String getCodigoPostal(){ return this.codigoPostal; }
    public List<ItemPedido> getItens(){ return this.itens; }
}
