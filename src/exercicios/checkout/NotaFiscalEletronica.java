package checkout;

import java.util.List;
import java.util.Random;

public class NotaFiscalEletronica extends DocumentoFiscal{ // ConcreteProductA (Brasil)
    private String ufVendedor;
    private String ufDestino;
    private String CFOP;
    private Double aliquotaICMS;
    private Double valorProdutos;
    private Double valorICMS;
    private String chaveAcesso;

    public NotaFiscalEletronica(String ufVendedor){
        this.ufVendedor = ufVendedor;
    }

    @Override
    public void emitir(Pedido pedido){
        this.ufDestino = pedido.getRegiao();
        this.valorProdutos = pedido.getSubtotal();

        if(this.ufDestino.equals(this.ufVendedor)){
            this.CFOP = "5.102";
            this.aliquotaICMS = 0.18;
        }else{
            this.CFOP = "6.102";
            this.aliquotaICMS = 0.12;
        }

        this.valorICMS = this.valorProdutos * this.aliquotaICMS;
        this.chaveAcesso = this.gerarChaveAcesso(pedido);

        /* LÓGICA
            dentro do estado: CFOP 5.102, ICMS 18%
            interestadual: CFOP 6.102, ICMS 12%
            chave de acesso simulada de 44 dígitos
        */
    }

    private String gerarChaveAcesso(Pedido pedido){
        Random random = new Random(pedido.getNumero().hashCode());
        StringBuilder chave = new StringBuilder();

        for(int i = 0; i < 44; i++){ chave.append(random.nextInt(10)); }

        return chave.toString();
    }

    @Override
    public Double getValorImposto(){ return this.valorICMS; }

    @Override
    public String getTipo(){ return "Nota Fiscal Eletrônica (NF-e)"; }

    @Override
    public List<String> getDetalhes(){
        return List.of(
            "CFOP: " + this.CFOP + " (" + this.ufVendedor + " -> " + this.ufDestino + ")",
            "Valor dos produtos: " + String.format("R$ %.2f", this.valorProdutos),
            "ICMS (" + String.format("%.0f%%", this.aliquotaICMS * 100) + "): " + String.format("R$ %.2f", this.valorICMS),
            "Chave de acesso: " + this.chaveAcesso.replaceAll("(.{4})(?!$)", "$1 ")
        );
    }
}
