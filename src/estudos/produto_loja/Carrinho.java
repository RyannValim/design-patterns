package estudos.produto_loja;

public class Carrinho{
    public double calcularTotal(Produto[] produtos){
        double resultado = 0;
        for(Produto produto : produtos){
            resultado += produto.calcularPrecoFinal();
        }
        return resultado;
    }
}