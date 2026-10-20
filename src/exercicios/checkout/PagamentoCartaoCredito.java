package checkout;

import java.util.List;

public class PagamentoCartaoCredito extends ProcessadorPagamento{ // ConcreteProductB (EUA)
    private String numeroCartao;
    private String zipCobranca;   // informado pelo cliente no checkout
    private String zipCadastrado; // registrado no banco emissor
    private Double valorCobrado;

    public PagamentoCartaoCredito(String numeroCartao, String zipCobranca, String zipCadastrado){
        this.numeroCartao = numeroCartao;
        this.zipCobranca = zipCobranca;
        this.zipCadastrado = zipCadastrado;
    }

    @Override
    public void processar(Pedido pedido, Double valorTotal){
        if(!this.zipCobranca.equals(this.zipCadastrado)){
            throw new PagamentoRecusadoException(
                "Pagamento recusado no pedido " + pedido.getNumero() + ": verificação AVS falhou (ZIP de cobrança não confere)."
            );
        }

        this.valorCobrado = valorTotal;

        // LÓGICA: cartão de crédito com verificação AVS (endereço de cobrança x cadastro do emissor)
    }

    @Override
    public String getTipo(){ return "Credit Card"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Cartão: **** **** **** " + this.numeroCartao.substring(this.numeroCartao.length() - 4),
            "AVS: aprovado (ZIP " + this.zipCobranca + ")",
            "Valor cobrado: " + String.format("US$ %.2f", this.valorCobrado)
        );
    }
}
