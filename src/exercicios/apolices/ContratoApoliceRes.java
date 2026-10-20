package apolices;

public class ContratoApoliceRes extends ContratoApolice{ // ConcreteCreator
    private String segurado;
    private Double valorImovel;
    private String tipoImovel;
    private String escritura;
    private String contratoLocacao;
    private String comprovanteRes;

    public ContratoApoliceRes(String segurado, Double valorImovel, String tipoImovel, String escritura, String contratoLocacao,
                              String comprovanteRes){
        this.segurado = segurado;
        this.valorImovel = valorImovel;
        this.tipoImovel = tipoImovel;
        this.escritura = escritura;
        this.contratoLocacao = contratoLocacao;
        this.comprovanteRes = comprovanteRes;
    }

    @Override
    protected Apolice criarApolice(){
        return new ApoliceRes(segurado, valorImovel, tipoImovel, escritura, contratoLocacao, comprovanteRes);
    }
}
