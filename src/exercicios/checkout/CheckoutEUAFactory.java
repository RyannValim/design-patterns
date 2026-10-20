package checkout;

public class CheckoutEUAFactory extends CheckoutFactory{ // ConcreteFactory
    private String EIN;
    private String numeroCartao;
    private String zipCobranca;
    private String zipCadastrado;

    public CheckoutEUAFactory(String EIN, String numeroCartao, String zipCobranca, String zipCadastrado){
        this.EIN = EIN;
        this.numeroCartao = numeroCartao;
        this.zipCobranca = zipCobranca;
        this.zipCadastrado = zipCadastrado;
    }

    @Override
    public DocumentoFiscal criarDocumentoFiscal(){ return new SalesInvoice(EIN); }

    @Override
    public ProcessadorPagamento criarProcessadorPagamento(){ return new PagamentoCartaoCredito(numeroCartao, zipCobranca, zipCadastrado); }

    @Override
    public EtiquetaEnvio criarEtiquetaEnvio(){ return new EtiquetaUSPS(); }
}
