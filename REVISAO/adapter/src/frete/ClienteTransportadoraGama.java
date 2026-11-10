package frete;

// Cliente do fornecedor Gama. Nao pode ser alterado.
public class ClienteTransportadoraGama {
    public TarifaGama consultarTarifa(
        int cepOrigem, int cepDestino, double pesoKg, boolean expresso
    ){
        double valorBruto = 15.00 * pesoKg;
        int prazoHoras = 70;

        if (expresso){
            valorBruto = valorBruto * 1.6;
            prazoHoras = 20;
        }

        return new TarifaGama(valorBruto, 0.20, prazoHoras);
    }
}
