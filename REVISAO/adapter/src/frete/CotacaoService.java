package frete;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CotacaoService {
    private final List<CalculadoraFrete> transportadoras;

    public CotacaoService(List<CalculadoraFrete> transportadoras){
        this.transportadoras = new ArrayList<>(transportadoras);
    }

    public void imprimirCotacoes(
        String cepOrigem, String cepDestino, double pesoKg
    ){
        for (CalculadoraFrete t : transportadoras){
            System.out.printf(Locale.of("pt", "BR"),
                "%-16s R$ %6.2f | %d dia(s)%n",
                t.nomeTransportadora(),
                t.calcular(cepOrigem, cepDestino, pesoKg),
                t.prazoDias(cepOrigem, cepDestino)
            );
        }
    }

    public CalculadoraFrete maisBarata(
        String cepOrigem, String cepDestino, double pesoKg
    ){
        if(transportadoras.isEmpty()){
            throw new IllegalStateException("Nenhuma transportadora cadastrada");
        }

        CalculadoraFrete melhor = null;
        double menorValor = Double.MAX_VALUE;

        for(CalculadoraFrete t : transportadoras){
            double valor = t.calcular(cepOrigem, cepDestino, pesoKg);

            if(valor < menorValor){
                menorValor = valor;
                melhor = t;
            }
        }

        return melhor;
    }
}
