package frete;

public class ServicoTransportadoraAlfa {
    public long cotarEntrega(
        String cepOrigem8, String cepDestino8, long pesoGramas
    ){
        exigirOitoDigitos(cepOrigem8);
        exigirOitoDigitos(cepDestino8);
        return 900 + pesoGramas;
    }

    public int estimarPrazo(
        String cepOrigem8, String cepDestino8
    ){
        exigirOitoDigitos(cepOrigem8);
        exigirOitoDigitos(cepDestino8);
        
        if(cepOrigem8.charAt(0) == cepDestino8.charAt(0)){
            return 2;
        }

        return 6;
    }

    private void exigirOitoDigitos(String cep){
        if(cep == null || cep.length() != 8){
            throw new IllegalArgumentException("CEP legado exige 8 dígitos sem hífen: " + cep);
        }
    }
}
