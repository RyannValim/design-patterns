package estudos.locacao_equipamentos;

public class PranchaDeSurf extends Equipamento implements Cautelavel{
    private double taxaManutencao = 15.00;
    private double valorCaucao = 100.00;

    @Override
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao + taxaManutencao;
    }

    @Override
    public double calcularCaucao(){
        return this.valorCaucao;
    }
}
