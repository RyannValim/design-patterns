package checkout;

import java.util.List;
import java.util.Map;

public class SalesInvoice extends DocumentoFiscal{ // ConcreteProductA (EUA)
    private static final Map<String, Double> SALES_TAX = Map.of(
        "CA", 0.0725,
        "TX", 0.0625,
        "OR", 0.0
    );

    private String EIN;
    private String estadoDestino;
    private Double aliquotaSalesTax;
    private Double valorProdutos;
    private Double valorSalesTax;

    public SalesInvoice(String EIN){
        this.EIN = EIN;
    }

    @Override
    public void emitir(Pedido pedido){
        this.estadoDestino = pedido.getRegiao();
        this.aliquotaSalesTax = SALES_TAX.get(this.estadoDestino);

        if(this.aliquotaSalesTax == null){
            throw new IllegalArgumentException("Estado americano não atendido: '" + this.estadoDestino + "'.");
        }

        this.valorProdutos = pedido.getSubtotal();
        this.valorSalesTax = this.valorProdutos * this.aliquotaSalesTax;

        /* LÓGICA
            sales tax conforme o estado de destino:
                California 7,25%, Texas 6,25%, Oregon isento
        */
    }

    @Override
    public Double getValorImposto(){ return this.valorSalesTax; }

    @Override
    public String getTipo(){ return "Sales Invoice"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Seller EIN: " + this.EIN,
            "Subtotal: " + String.format("US$ %.2f", this.valorProdutos),
            "Sales tax " + this.estadoDestino + " (" + String.format("%.2f%%", this.aliquotaSalesTax * 100) + "): "
                + String.format("US$ %.2f", this.valorSalesTax)
        );
    }
}
