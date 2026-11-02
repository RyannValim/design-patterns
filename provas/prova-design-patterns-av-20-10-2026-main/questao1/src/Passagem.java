public abstract class Passagem{
    protected Double valorTarifa;
    
    public abstract Double calcTaxaEmbarque();

    public void imprimirResumo(String nomePassageiro, String docIdentidade){
        System.out.println("======== Resumo ========\n");
        System.out.println("  Passageiro: '" + nomePassageiro + "'");
        System.out.println("  Taxa de embarque: " + this.calcTaxaEmbarque());
        System.out.println("\nDocumentos exigidos:");
        System.err.println("  Identidade: '" + docIdentidade + "'");
        System.out.println("========================\n");
    }
}