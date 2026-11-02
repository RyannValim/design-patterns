public class PassagemAerea extends Passagem{
    private String bilheteEletronico;

    public PassagemAerea(){
        this.valorTarifa = 750.00;
        this.bilheteEletronico = "AER-2109310S";
    }
    
    @Override
    public Double calcTaxaEmbarque(){
        return this.valorTarifa * 0.08;
    }

    @Override
    public void imprimirResumo(String nomePassageiro, String docIdentidade){
        System.out.println("======== Resumo ========\n");
        System.out.println("  Passageiro: '" + nomePassageiro + "'");
        System.out.println("  Taxa de embarque: R$" + this.calcTaxaEmbarque());
        System.out.println("\nDocumentos exigidos:");
        System.out.println("  Identidade: " + docIdentidade);
        System.out.println("  Bilhete Eletrônico: " + this.bilheteEletronico);
        System.out.println("========================\n");
    }
}
