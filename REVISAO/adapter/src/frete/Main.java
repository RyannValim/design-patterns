package frete;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String origem = "80010-000";
        String destino = "01310-100";
        double pesoKg = 2.5;

        CotacaoService cotacao = new CotacaoService(List.of(
            new FreteAlfaAdapter(new ServicoTransportadoraAlfa()),
            new FreteBetaAdapter(new ApiTransportadoraBeta()),
            new FreteGamaAdapter(new ClienteTransportadoraGama(), false),
            new FreteGamaAdapter(new ClienteTransportadoraGama(), true)
        ));

        System.out.println("Cotacoes de " + origem + " para " + destino + " - " + pesoKg + " kg");
        cotacao.imprimirCotacoes(origem, destino, pesoKg);

        CalculadoraFrete melhor = cotacao.maisBarata(origem, destino, pesoKg);
        System.out.println("Mais barata: " + melhor.nomeTransportadora());
    }
}
