package checkout;

public class CheckoutAlemanhaFactory extends CheckoutFactory{ // ConcreteFactory
    private String vatId;
    private String IBAN;

    public CheckoutAlemanhaFactory(String vatId, String IBAN){
        this.vatId = vatId;
        this.IBAN = IBAN;
    }

    @Override
    public DocumentoFiscal criarDocumentoFiscal(){ return new VatInvoice(vatId); }

    @Override
    public ProcessadorPagamento criarProcessadorPagamento(){ return new PagamentoSepa(IBAN); }

    @Override
    public EtiquetaEnvio criarEtiquetaEnvio(){ return new EtiquetaDeutschePost(); }
}
