package estudos.locacao_equipamentos.src;

public class Kart extends Equipamento implements Cautelavel{
    @Override
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao * 1.2;
    }

    @Override
    public double calcularCaucao(){
        double valorLocacao = calcularValorLocacao();
        return valorLocacao * 0.5;
    }
}
