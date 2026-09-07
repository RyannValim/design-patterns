package estudos.locacao_equipamentos.src;

public class Main {
    public static void main(String[] args){
        ServicoDeLocacao servicoDeLocacao = new ServicoDeLocacao();
        
        // Locando uma bicicleta
        int diasLocacaoBicicleta = 7;

        Equipamento bicicleta = new Bicicleta();
        bicicleta.nome = "Caloi-2X26";
        bicicleta.valorDiaria = 2.50;
        System.out.println(servicoDeLocacao.processarLocacao(bicicleta, diasLocacaoBicicleta));

        // Locando uma PranchaDeSurf
        int diasLocacaoPranchaDeSurf = 3;

        PranchaDeSurf pranchaDeSurf = new PranchaDeSurf();
        pranchaDeSurf.nome = "Prancha-1X23";
        pranchaDeSurf.valorDiaria = 3.30;
        System.out.println(servicoDeLocacao.processarLocacao(pranchaDeSurf, diasLocacaoPranchaDeSurf));

        // Locando um Kart
        int diasLocacaoKart = 5;

        Kart kart = new Kart();
        kart.nome = "Kart-9x02";
        kart.valorDiaria = 4.25;
        System.out.println(servicoDeLocacao.processarLocacao(kart, diasLocacaoKart));

        // Somando o total de cauções
        Cautelavel[] cautelaveis = {pranchaDeSurf, kart};
        CalculadoraDeCaucao calculadoraDeCaucao = new CalculadoraDeCaucao();
        double totalCaucao = calculadoraDeCaucao.somarTotalCaucao(cautelaveis);
        
        System.out.println("O total de caução é igual a: R$" + totalCaucao);
    }
}
