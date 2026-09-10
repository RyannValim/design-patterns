package estudos.produto_loja;

public abstract class Produto{
    protected String nome;
    protected double precoBase;

    public abstract double calcularPrecoFinal();
}