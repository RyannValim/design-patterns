package frete;

public class FreteAlfaAdapter implements CalculadoraFrete{
    private final ServicoTransportadoraAlfa alfa;

    public FreteAlfaAdapter(
        ServicoTransportadoraAlfa alfa
    ){
        this.alfa = alfa;
    }

    @Override
    public double calcular(String cepOrigem, String cepDestino, double pesoKg){
        long pesoGramas = Math.round(pesoKg * 1000);
        long centavos = alfa.cotarEntrega(semHifen(cepOrigem), semHifen(cepDestino), pesoGramas);
        return centavos / 100.0;
    }

    @Override
    public int prazoDias(String cepOrigem, String cepDestino){
        return alfa.estimarPrazo(semHifen(cepOrigem), semHifen(cepDestino));
    }

    @Override
    public String nomeTransportadora(){
        return "Alfa";
    }

    private String semHifen(String cep){
        return cep.replace("-", "");
    }
}
