package pedido.normal;

public class EnvioEntregador{
    private String statusPedido;

    public void update(String status){
        this.statusPedido = status;
        System.out.println("Status do pedido em EnvioEntregador atualizado para: '" + this.statusPedido + "'");
    }
}
