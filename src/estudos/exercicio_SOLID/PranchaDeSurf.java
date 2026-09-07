package estudos.exercicio_SOLID;

public class PranchaDeSurf extends Equipamento implements Cautelavel{
    private double taxaManutencao = 15.00;
    private double valorCaucao = 100.00;

    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao + taxaManutencao;
    }

    public double calcularCaucao(){
        return this.valorCaucao;
    }
}
