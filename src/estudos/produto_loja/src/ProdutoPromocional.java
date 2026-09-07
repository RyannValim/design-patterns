package estudos.produto_loja.src;

public class ProdutoPromocional extends Produto{
    @Override
    public double calcularPrecoFinal(){
        return precoBase * 0.90;
    }
}