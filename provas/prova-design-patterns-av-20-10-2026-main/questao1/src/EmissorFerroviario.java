public class EmissorFerroviario extends Emissor{
    public Passagem criarPassagem(){
        return new PassagemFerroviaria();
    }
}
