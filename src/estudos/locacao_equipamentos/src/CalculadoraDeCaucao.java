package estudos.locacao_equipamentos.src;

public class CalculadoraDeCaucao{
    public double somarTotalCaucao(Cautelavel[] cautelaveis){
        double totalCaucao = 0.00;

        for (Cautelavel cautelavel : cautelaveis) {
            totalCaucao += cautelavel.calcularCaucao();
        }

        return totalCaucao;
    }
}
