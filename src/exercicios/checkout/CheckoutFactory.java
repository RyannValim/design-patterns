package checkout;

/*
    3 países de operação
    Brasil
    Estados Unidos
    Alemanha

    Cada fábrica cria a família completa de artefatos de um único país,
    então não tem como misturar NF-e brasileira com etiqueta da USPS.
    Na adição de um 4° país, não pode ferir Open/Closed
*/

public abstract class CheckoutFactory{ // AbstractFactory
    public abstract DocumentoFiscal criarDocumentoFiscal();
    public abstract ProcessadorPagamento criarProcessadorPagamento();
    public abstract EtiquetaEnvio criarEtiquetaEnvio();
}
