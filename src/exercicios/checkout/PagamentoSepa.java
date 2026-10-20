package checkout;

import java.util.List;

public class PagamentoSepa extends ProcessadorPagamento{ // ConcreteProductB (Alemanha)
    private String IBAN;
    private String referenciaMandato;
    private Double valorCobrado;

    public PagamentoSepa(String IBAN){
        this.IBAN = IBAN;
    }

    @Override
    public void processar(Pedido pedido, Double valorTotal){
        this.referenciaMandato = "MNDT-" + pedido.getNumero();
        this.valorCobrado = valorTotal;

        // LÓGICA: SEPA Direct Debit (débito em conta via mandato)
    }

    @Override
    public String getTipo(){ return "SEPA Direct Debit"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "IBAN: " + this.IBAN.substring(0, 4) + " **** **** **** " + this.IBAN.substring(this.IBAN.length() - 4),
            "Mandatsreferenz: " + this.referenciaMandato,
            "Valor debitado: " + String.format("€ %.2f", this.valorCobrado)
        );
    }
}
