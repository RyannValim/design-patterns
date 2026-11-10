package frete;

public interface CalculadoraFrete { // TARGET
    public double calcular(String cepOrigem, String cepDestino, double pesoKg);
    public int prazoDias(String cepOrigem, String cepDestino);
    public String nomeTransportadora();
}
