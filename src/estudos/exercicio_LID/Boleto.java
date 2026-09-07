package estudos.exercicio_LID;

public class Boleto implements FormaPagamento{
    public String processarPagamento(double valor){
        return "Pagamento via Boleto realizado no valor de R$" + valor;
    }
}
