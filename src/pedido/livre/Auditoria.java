package pedido.livre;

public class Auditoria{
    private String statusPedido;

    public void update(String status){
        this.statusPedido = status;
        System.out.println("Status do pedido em Auditoria atualizado para: '" + this.statusPedido + "'");
    }
}
