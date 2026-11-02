public class PassagemFerroviaria extends Passagem{
    private String comprovanteReserva;

    public PassagemFerroviaria(){
        this.valorTarifa = 200.00;
        this.comprovanteReserva = "COMPR-N°123182-2026";
    }

    @Override
    public Double calcTaxaEmbarque(){
        return this.valorTarifa * 0.05;
    }

    @Override
    public void imprimirResumo(String nomePassageiro, String docIdentidade){
        System.out.println("======== Resumo ========\n");
        System.out.println("  Passageiro: '" + nomePassageiro + "'");
        System.out.println("  Taxa de embarque: " + this.calcTaxaEmbarque());
        System.out.println("\nDocumentos exigidos:");
        System.out.println("  Identidade: " + docIdentidade);
        System.out.println("  Comprovante Reserva: " + this.comprovanteReserva);
        System.out.println("========================\n");
    }
}
