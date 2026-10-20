package checkout;

public class CheckoutBrasilFactory extends CheckoutFactory{ // ConcreteFactory
    private String ufVendedor;
    private String formaPagamento;

    public CheckoutBrasilFactory(String ufVendedor, String formaPagamento){
        this.ufVendedor = ufVendedor;
        this.formaPagamento = formaPagamento;
    }

    @Override
    public DocumentoFiscal criarDocumentoFiscal(){ return new NotaFiscalEletronica(ufVendedor); }

    @Override
    public ProcessadorPagamento criarProcessadorPagamento(){ return new PagamentoBrasil(formaPagamento); }

    @Override
    public EtiquetaEnvio criarEtiquetaEnvio(){ return new EtiquetaCorreios(); }
}
