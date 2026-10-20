package checkout;

import java.util.List;

public class Checkout{ // Client
    private CheckoutFactory factory;

    // a única forma de obter os artefatos é pela fábrica recebida, então todos são do mesmo país
    public Checkout(CheckoutFactory factory){
        this.factory = factory;
    }

    public String finalizarPedido(Pedido pedido){
        DocumentoFiscal documentoFiscal = this.factory.criarDocumentoFiscal();
        ProcessadorPagamento processadorPagamento = this.factory.criarProcessadorPagamento();
        EtiquetaEnvio etiquetaEnvio = this.factory.criarEtiquetaEnvio();

        documentoFiscal.emitir(pedido);
        processadorPagamento.processar(pedido, pedido.getSubtotal() + documentoFiscal.getValorImposto());
        etiquetaEnvio.gerar(pedido);

        return this.gerarRelatorio(pedido, documentoFiscal, processadorPagamento, etiquetaEnvio);
    }

    // RNF03: mesmo formato de relatório para qualquer país
    private String gerarRelatorio(Pedido pedido, DocumentoFiscal documentoFiscal, ProcessadorPagamento processadorPagamento,
                                  EtiquetaEnvio etiquetaEnvio){
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("==========================================\n");
        relatorio.append("Pedido: " + pedido.getNumero() + "\n");
        relatorio.append("Cliente: " + pedido.getCliente() + "\n");
        relatorio.append("Itens:\n");
        for(ItemPedido item : pedido.getItens()){
            relatorio.append("  - " + item.getQuantidade() + "x " + item.getDescricao() + String.format(" (%.2f)", item.getValorTotal()) + "\n");
        }

        this.anexarArtefato(relatorio, "DOCUMENTO FISCAL", documentoFiscal);
        this.anexarArtefato(relatorio, "PAGAMENTO", processadorPagamento);
        this.anexarArtefato(relatorio, "ETIQUETA DE ENVIO", etiquetaEnvio);

        relatorio.append("==========================================");

        return relatorio.toString();
    }

    private void anexarArtefato(StringBuilder relatorio, String titulo, ArtefatoCheckout artefato){
        relatorio.append("[" + titulo + "] " + artefato.getTipo() + "\n");
        for(String detalhe : artefato.getDetalhes()){ relatorio.append("  " + detalhe + "\n"); }
    }
}
