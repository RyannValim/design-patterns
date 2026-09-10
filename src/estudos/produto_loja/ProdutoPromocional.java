package estudos.produto_loja;

public class ProdutoPromocional extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase * 0.90;
    }
}