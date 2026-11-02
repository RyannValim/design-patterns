public class EmissorRodoviario extends Emissor{
    public Passagem criarPassagem(){
        return new PassagemRodoviaria();
    }
}
