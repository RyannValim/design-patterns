package pedido.livre;

public class NotaFiscal{
    private String statusPedido;

    public void update(String status){
        this.statusPedido = status;
        System.out.println("Status do pedido em NotaFiscal atualizado para: '" + this.statusPedido + "'");
    }
}
