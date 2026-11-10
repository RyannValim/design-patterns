package frete;

import java.util.Locale;

public class ApiTransportadoraBeta {
    public String simular(String cepOrigem, String cepDestino, double kg){
        exigirComHifen(cepOrigem);
        exigirComHifen(cepDestino);
        double valor = 14.90 + (8.50 * kg);
        return String.format(
            Locale.of("pt", "BR"),
            "R$ %.2f",
            valor
        );
    }    

    public String previsaoEntrega(String cepOrigem, String cepDestino){
        exigirComHifen(cepOrigem);
        exigirComHifen(cepDestino);
        if(cepOrigem.charAt(0) == cepDestino.charAt(0)){
            return "2 dias atrás";
        }
        return "5 dias úteis";
    }

    private void exigirComHifen(String cep){
        if(cep == null || cep.length() != 9 || cep.charAt(5) != '-'){
            throw new IllegalArgumentException(
                "API Beta exige CEP no formato 00000-000: " + cep
            );
        }
    }
}
