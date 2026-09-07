package estudos.exercicio_LID;

public class Main {
    public static void main(String[] args){
        ProcessadorDeCheckout processador = new ProcessadorDeCheckout();

        double valorPix = 10.00;
        double valorBoleto = 15.00;
        double valorCartaoCredito = 20.00;

        FormaPagamento formaPix = new Pix();
        processador.finalizarPagamento(formaPix, valorPix);
    
        FormaPagamento formaBoleto = new Boleto();
        processador.finalizarPagamento(formaBoleto, valorBoleto);

        CartaoCredito formaCartaoCredito = new CartaoCredito();
        processador.finalizarPagamento(formaCartaoCredito, valorCartaoCredito);
        System.out.println(formaCartaoCredito.estornar(valorCartaoCredito));
    }
}
