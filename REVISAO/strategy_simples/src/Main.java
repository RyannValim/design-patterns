import java.util.Locale;

public class Main {
    private static void imprimir(Carrinho c){
        System.out.printf(Locale.of("pt", "BR"),
            "%-8s | R$ %.2f%n", c.formaEscolhida(), c.total()
        );
    }
    public static void main(String args[]){
        Carrinho carrinho = new Carrinho(200.00, new DescontoAVista());
        imprimir(carrinho);

        carrinho.setDesconto(new DescontoDebito());
        imprimir(carrinho);

        carrinho.setDesconto(new SemDesconto());
        imprimir(carrinho);
    }
}
