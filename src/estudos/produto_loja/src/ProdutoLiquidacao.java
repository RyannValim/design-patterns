package estudos.produto_loja.src;

public class ProdutoLiquidacao extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase * 0.70;
    }
}
