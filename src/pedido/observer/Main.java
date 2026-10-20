package pedido.observer;

public class Main {
    public static void main(String[] args){
        Pedido p = new Pedido();

        Auditoria auditoria = new Auditoria();
        AvisoCliente avisoCliente = new AvisoCliente();
        PainelCozinha painelCozinha = new PainelCozinha();
        EnvioEntregador envioEntregador = new EnvioEntregador();
        NotaFiscal notaFiscal = new NotaFiscal();

        p.inscrever(auditoria);
        p.inscrever(avisoCliente);
        p.inscrever(painelCozinha);
        p.inscrever(envioEntregador);
        p.inscrever(notaFiscal);

        System.out.println("Preparando o pedido!");
        p.setStatusPedido("Preparando");

        System.out.println("\nO pedido ficou pronto!");
        p.setStatusPedido("Pedido pronto");
    }
}
