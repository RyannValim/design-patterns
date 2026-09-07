package estudos.exercicio_SO;

public class ProdutoComum extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase;
    }
}
