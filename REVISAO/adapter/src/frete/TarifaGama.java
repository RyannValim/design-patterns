package frete;

// Objeto de resposta do fornecedor Gama. Nao pode ser alterado.
public class TarifaGama {
    private final double valorBruto;
    private final double desconto;
    private final int prazoHoras;

    public TarifaGama(double valorBruto, double desconto, int prazoHoras){
        this.valorBruto = valorBruto;
        this.desconto = desconto;
        this.prazoHoras = prazoHoras;
    }

    public double getValorBruto(){
        return valorBruto;
    }

    public double getDesconto(){
        return desconto;
    }

    public int getPrazoHoras(){
        return prazoHoras;
    }
}
