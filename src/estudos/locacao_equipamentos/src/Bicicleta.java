package estudos.locacao_equipamentos.src;

public class Bicicleta extends Equipamento{
    @Override
    public double calcularValorLocacao(){
        return valorDiaria * this.diasLocacao;
    }
}
