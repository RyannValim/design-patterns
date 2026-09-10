package estudos.produto_loja;

public class ProdutoComum extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase;
    }
}
