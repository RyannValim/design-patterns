package checkout;

import java.util.List;

public class EtiquetaCorreios extends EtiquetaEnvio{ // ConcreteProductC (Brasil)
    private String destinatario;
    private String endereco;
    private String CEP;
    private String codigoRastreio;

    @Override
    public void gerar(Pedido pedido){
        String digitos = pedido.getCodigoPostal().replaceAll("\\D", "");

        if(digitos.length() != 8){
            throw new IllegalArgumentException("CEP inválido: '" + pedido.getCodigoPostal() + "'.");
        }

        this.destinatario = pedido.getCliente();
        this.endereco = pedido.getEndereco() + " - " + pedido.getRegiao();
        this.CEP = digitos.substring(0, 5) + "-" + digitos.substring(5);
        this.codigoRastreio = "BR" + String.format("%09d", Math.abs(pedido.getNumero().hashCode()) % 1000000000) + "BR";

        // LÓGICA: Correios, CEP no formato 00000-000
    }

    @Override
    public String getTipo(){ return "Correios"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Destinatário: " + this.destinatario,
            "Endereço: " + this.endereco,
            "CEP: " + this.CEP,
            "Rastreio: " + this.codigoRastreio
        );
    }
}
