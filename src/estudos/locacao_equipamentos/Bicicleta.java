package estudos.locacao_equipamentos;

public class Bicicleta extends Equipamento{
    @Override
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao;
    }
}
