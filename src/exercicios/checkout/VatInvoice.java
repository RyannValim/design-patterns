package checkout;

import java.util.List;

public class VatInvoice extends DocumentoFiscal{ // ConcreteProductA (Alemanha)
    private String vatId;
    private Double baseEssenciais = 0.0;
    private Double baseDemais = 0.0;
    private Double valorUmsatzsteuer;

    public VatInvoice(String vatId){
        this.vatId = vatId;
    }

    @Override
    public void emitir(Pedido pedido){
        for(ItemPedido item : pedido.getItens()){
            if(item.isEssencial()){ this.baseEssenciais += item.getValorTotal(); }
            else{ this.baseDemais += item.getValorTotal(); }
        }

        this.valorUmsatzsteuer = this.baseEssenciais * 0.07 + this.baseDemais * 0.19;

        /* LÓGICA
            Umsatzsteuer de 19%
                produtos essenciais, 7%
        */
    }

    @Override
    public Double getValorImposto(){ return this.valorUmsatzsteuer; }

    @Override
    public String getTipo(){ return "VAT Invoice (Rechnung)"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "USt-IdNr. (VAT-ID): " + this.vatId,
            "Netto 19%: " + String.format("€ %.2f", this.baseDemais) + " | USt: " + String.format("€ %.2f", this.baseDemais * 0.19),
            "Netto 7%: " + String.format("€ %.2f", this.baseEssenciais) + " | USt: " + String.format("€ %.2f", this.baseEssenciais * 0.07),
            "Umsatzsteuer total: " + String.format("€ %.2f", this.valorUmsatzsteuer)
        );
    }
}
