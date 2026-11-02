public abstract class Relatorio {
    protected String docFiscal;
    protected String taxa;
    protected String formaPag;
    protected String idAluno;

    public abstract void imprimirRelatorio(String nomeAluno);
}
