package frete;

public class FreteBetaAdapter implements CalculadoraFrete {
    private final ApiTransportadoraBeta beta;

    public FreteBetaAdapter(ApiTransportadoraBeta beta) {
        this.beta = beta;
    }

    @Override
    public double calcular(String cepOrigem, String cepDestino, double pesoKg) {
        String texto = beta.simular(cepOrigem, cepDestino, pesoKg);
        String numero = texto.replace(
            "R$", "")
            .trim()
            .replace(",", "."
                
            );
        return Double.parseDouble(numero);
    }

    @Override
    public int prazoDias(String cepOrigem, String cepDestino) {
        String texto = beta.previsaoEntrega(cepOrigem, cepDestino);
        String numero = texto.split(" ")[0];
        return Integer.parseInt(numero);
    }

    @Override
    public String nomeTransportadora() {
        return "Beta";
    }
}
