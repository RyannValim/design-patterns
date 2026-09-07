package estudos.exercicio_SOLID;

public class Bicicleta extends Equipamento{
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao;
    }
}
