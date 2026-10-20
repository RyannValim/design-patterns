package checkout;

import java.util.List;

public class EtiquetaUSPS extends EtiquetaEnvio{ // ConcreteProductC (EUA)
    private String destinatario;
    private String endereco;
    private String ZIP;
    private String codigoRastreio;

    @Override
    public void gerar(Pedido pedido){
        String digitos = pedido.getCodigoPostal().replaceAll("\\D", "");

        if(digitos.length() != 9){
            throw new IllegalArgumentException("ZIP+4 inválido: '" + pedido.getCodigoPostal() + "'.");
        }

        this.destinatario = pedido.getCliente();
        this.endereco = pedido.getEndereco() + ", " + pedido.getRegiao();
        this.ZIP = digitos.substring(0, 5) + "-" + digitos.substring(5);
        this.codigoRastreio = "9400" + String.format("%018d", (long) Math.abs(pedido.getNumero().hashCode()));

        // LÓGICA: USPS, formato ZIP+4 (00000-0000)
    }

    @Override
    public String getTipo(){ return "USPS"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "Recipient: " + this.destinatario,
            "Address: " + this.endereco,
            "ZIP+4: " + this.ZIP,
            "Tracking: " + this.codigoRastreio
        );
    }
}
