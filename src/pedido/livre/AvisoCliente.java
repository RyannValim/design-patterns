package pedido.livre;

public class AvisoCliente{
    private String statusPedido;

    public void update(String status){
        this.statusPedido = status;
        System.out.println("Status do pedido em AvisoCliente atualizado para: '" + this.statusPedido + "'");
    }
}
