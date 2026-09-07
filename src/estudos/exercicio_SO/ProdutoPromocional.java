package estudos.exercicio_SO;

public class ProdutoPromocional extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase * 0.90;
    }
}