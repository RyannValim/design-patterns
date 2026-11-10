package frete;

public class FreteGamaAdapter implements CalculadoraFrete{
    private final ClienteTransportadoraGama gama;
    private final boolean expresso;

    public FreteGamaAdapter(ClienteTransportadoraGama gama, boolean expresso){
        this.gama = gama;
        this.expresso = expresso;
    }

    @Override
    public double calcular(String cepOrigem, String cepDestino, double pesoKg){
        TarifaGama tarifa = gama.consultarTarifa(
            paraInteiro(cepOrigem), paraInteiro(cepDestino), pesoKg, expresso
        );
        return tarifa.getValorBruto() * (1 - tarifa.getDesconto());
    }

    @Override
    public int prazoDias(String cepOrigem, String cepDestino){
        TarifaGama tarifa = gama.consultarTarifa(
            paraInteiro(cepOrigem), paraInteiro(cepDestino), 0.0, expresso
        );
        return (int) Math.ceil(tarifa.getPrazoHoras() / 24.0);
    }

    @Override
    public String nomeTransportadora(){
        if(expresso){
            return "Gama Expresso";
        }
        return "Gama";
    }

    private int paraInteiro(String cep){
        String digitos = cep.replace("-", "");
        if(digitos.length() != 8){
            throw new IllegalArgumentException("CEP deve ter 8 digitos: " + cep);
        }
        return Integer.parseInt(digitos);
    }
}
