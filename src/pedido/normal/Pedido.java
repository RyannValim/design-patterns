package pedido.normal;

public class Pedido {
    private String status;
    private Auditoria auditoria;
    private AvisoCliente avisoCliente;
    private PainelCozinha painelCozinha;
    private EnvioEntregador envioEntregador;
    private NotaFiscal notaFiscal;

    public Pedido(){
        this.auditoria = new Auditoria();
        this.avisoCliente = new AvisoCliente();
        this.painelCozinha = new PainelCozinha();
        this.envioEntregador = new EnvioEntregador();
        this.notaFiscal = new NotaFiscal();
    }

    public void setStatus(String status){ this.status = status; }
    public String getStatus(){ return this.status; }

    public void notificar(){
        this.auditoria.update(this.getStatus());
        this.avisoCliente.update(this.getStatus());
        this.painelCozinha.update(this.getStatus());
        this.envioEntregador.update(this.getStatus());
        this.notaFiscal.update(this.getStatus());
    }
}
