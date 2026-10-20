package checkout;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PagamentoBrasil extends ProcessadorPagamento{ // ConcreteProductB (Brasil)
    private String formaPagamento; // PIX ou BOLETO
    private Double valorOriginal;
    private Double valorCobrado;
    private LocalDate dataCompensacao;

    public PagamentoBrasil(String formaPagamento){
        this.formaPagamento = formaPagamento;
    }

    @Override
    public void processar(Pedido pedido, Double valorTotal){
        this.valorOriginal = valorTotal;

        if(this.formaPagamento.equals("PIX")){
            this.valorCobrado = valorTotal * 0.95;
            this.dataCompensacao = LocalDate.now();
        }else{
            this.valorCobrado = valorTotal;
            this.dataCompensacao = this.somarDiasUteis(LocalDate.now(), 3);
        }

        /* LÓGICA
            Pix: desconto de 5%, compensação imediata
            Boleto: compensação em 3 dias úteis
        */
    }

    private LocalDate somarDiasUteis(LocalDate data, int dias){
        while(dias > 0){
            data = data.plusDays(1);
            if(data.getDayOfWeek() != DayOfWeek.SATURDAY && data.getDayOfWeek() != DayOfWeek.SUNDAY){ dias--; }
        }

        return data;
    }

    @Override
    public String getTipo(){ return this.formaPagamento.equals("PIX") ? "Pix" : "Boleto Bancário"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Valor do pedido: " + String.format("R$ %.2f", this.valorOriginal),
            "Desconto: " + String.format("R$ %.2f", this.valorOriginal - this.valorCobrado),
            "Valor cobrado: " + String.format("R$ %.2f", this.valorCobrado),
            "Compensação: " + this.dataCompensacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
    }
}
