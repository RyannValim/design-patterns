package pedido.livre;

public class PainelCozinha{
    private String statusPedido;

    public void update(String status){
        this.statusPedido = status;
        System.out.println("Status do pedido em PainelCozinha atualizado para: '" + this.statusPedido + "'");
    }
}
