public abstract class Emissor {
    public abstract Passagem criarPassagem();

    public void emitirPassagem(String nomePassageiro, String docIdentidade){
        Passagem p = criarPassagem();
        p.imprimirResumo(nomePassageiro, docIdentidade);
    }
}
