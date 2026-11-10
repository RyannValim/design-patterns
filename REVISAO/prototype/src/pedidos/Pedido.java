package pedidos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Pedido implements Prototype<Pedido>{
    private static long proximoId = 1;
    private long id;
    private String cliente;
    private String enderecoEntrega;
    private List<ItemPedido> itens = new ArrayList<>();
    private LocalDate criadoEm;

    public Pedido(
        String cliente, String enderecoEntrega
    ){
        this.id = proximoId++;
        this.criadoEm = LocalDate.now();
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public long getId() { return this.id;}

    public void setCliente(String cliente){ this.cliente = cliente; }
    public String getCliente() { return this.cliente; }

    public void setEnderecoEntrega(String enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
    public String getEnderecoEntrega() { return this.enderecoEntrega; }

    public List<ItemPedido> getItens() { return itens; }

    public LocalDate getCriadoEm() { return this.criadoEm; }

    @Override
    public Pedido clonar(){
        Pedido copia = new Pedido(this.cliente, this.enderecoEntrega);
        for(ItemPedido item : this.itens){
            copia.itens.add(new ItemPedido(item));
        }

        return copia;
    }

    public BigDecimal valorTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for(ItemPedido item : itens){
            total = total.add(item.subtotal());
        }
        
        return total.setScale(2, RoundingMode.HALF_UP);
    }

    public void adicionar(ItemPedido item){
        itens.add(item);
    }
}
