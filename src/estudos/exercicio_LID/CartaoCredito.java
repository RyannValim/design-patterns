package estudos.exercicio_LID;

public class CartaoCredito implements FormaPagamento, Reembolsavel{
    public String processarPagamento(double valor){
        return "Pagamento via Cartão de Crédito realizado no valor de R$" + valor;
    }

    public String estornar(double valor){
        return "O valor R$" + valor + " foi estornado para a conta!";
    }
}
