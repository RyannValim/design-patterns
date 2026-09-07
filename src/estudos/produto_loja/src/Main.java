package estudos.produto_loja.src;

public class Main {
    public static void main(String[] args){
        // Criação de produtos e adição ao array
        Produto produto1 = new ProdutoComum();
        produto1.nome = "Detergente";
        produto1.precoBase = 10.00;

        Produto produto2 = new ProdutoLiquidacao();
        
        produto2.nome = "Amaciante";
        produto2.precoBase = 10.00;

        Produto produto3 = new ProdutoPromocional();
        produto3.nome = "Sabonete";
        produto3.precoBase = 10.00;
        
        // Criando um array de produtos
        Produto[] produtos = {produto1, produto2, produto3};

        // Carrinho
        Carrinho carrinho = new Carrinho();
        double resultadoCarrinho = carrinho.calcularTotal(produtos);
        System.out.println("Total no Carrinho: R$" + resultadoCarrinho + "\n");

        // Recibo
        ImpressoraRecibo impressora = new ImpressoraRecibo();
        String resultadoRecibo = impressora.imprimirRecibo(produtos);
        System.out.println("Imprimindo recibo...\n" + resultadoRecibo);
    }
}
