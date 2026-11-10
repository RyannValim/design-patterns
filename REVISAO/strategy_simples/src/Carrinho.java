public class Carrinho { // Context
    private final double valor;
    private Desconto desconto;

    public Carrinho(double valor, Desconto desconto){
        this.valor = valor;
        this.desconto = desconto;
    }

    public void setDesconto(Desconto desconto){ this.desconto = desconto; }
    
    public double total(){ return desconto.aplicar(valor); }

    public String formaEscolhida(){ return desconto.nome(); }
}
