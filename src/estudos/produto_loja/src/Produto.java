package estudos.produto_loja.src;

public abstract class Produto{
    protected String nome;
    protected double precoBase;

    public abstract double calcularPrecoFinal();
}