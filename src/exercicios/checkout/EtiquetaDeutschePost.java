package checkout;

import java.util.List;

public class EtiquetaDeutschePost extends EtiquetaEnvio{ // ConcreteProductC (Alemanha)
    private String destinatario;
    private String endereco;
    private String PLZ;
    private String codigoRastreio;

    @Override
    public void gerar(Pedido pedido){
        String digitos = pedido.getCodigoPostal().replaceAll("\\D", "");

        if(digitos.length() != 5){
            throw new IllegalArgumentException("PLZ inválido: '" + pedido.getCodigoPostal() + "'.");
        }

        this.destinatario = pedido.getCliente();
        this.endereco = pedido.getEndereco() + ", " + pedido.getRegiao();
        this.PLZ = digitos;
        this.codigoRastreio = "RR" + String.format("%09d", Math.abs(pedido.getNumero().hashCode()) % 1000000000) + "DE";

        // LÓGICA: Deutsche Post, PLZ de 5 dígitos
    }

    @Override
    public String getTipo(){ return "Deutsche Post"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Empfänger: " + this.destinatario,
            "Adresse: " + this.endereco,
            "PLZ: " + this.PLZ,
            "Sendungsnummer: " + this.codigoRastreio
        );
    }
}
