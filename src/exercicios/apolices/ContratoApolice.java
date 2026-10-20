package apolices;

public abstract class ContratoApolice{ // Creator
    protected abstract Apolice criarApolice(); // factoryMethod

    // algoritmo de contratação centralizado, usando apenas a abstração Apolice
    public final Apolice processarContratacao(){
        Apolice apolice = this.criarApolice();

        if(!apolice.validarCobertura()){
            throw new ContratacaoRejeitadaException(
                "Contratação rejeitada (" + apolice.getPrefixo() + ") para " + apolice.getSegurado()
                + ": requisitos mínimos de cobertura/documentação não atendidos."
            );
        }

        apolice.emitir();

        return apolice;
    }
}
