package estudos.exercicio_LID;

public class ProcessadorDeCheckout{
    public void finalizarPagamento(FormaPagamento forma, double valor){
        System.out.println(forma.processarPagamento(valor));
    }
}
