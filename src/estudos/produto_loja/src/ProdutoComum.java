package estudos.produto_loja.src;

public class ProdutoComum extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase;
    }
}
