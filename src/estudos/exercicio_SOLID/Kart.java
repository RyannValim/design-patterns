package estudos.exercicio_SOLID;

public class Kart extends Equipamento implements Cautelavel{
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao * 1.2;
    }

    public double calcularCaucao(){
        double valorLocacao = calcularValorLocacao();
        return valorLocacao * 0.5;
    }
}
