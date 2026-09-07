package estudos.exercicio_LID;

public class Pix implements FormaPagamento{
    public String processarPagamento(double valor){
        return "Pagamento via PIX realizado no valor de R$" + valor;
    }
}
