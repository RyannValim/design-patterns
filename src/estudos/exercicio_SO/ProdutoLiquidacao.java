package estudos.exercicio_SO;

public class ProdutoLiquidacao extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase * 0.70;
    }
}
