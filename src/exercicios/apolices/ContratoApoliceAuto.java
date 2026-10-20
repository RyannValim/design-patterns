package apolices;

public class ContratoApoliceAuto extends ContratoApolice{ // ConcreteCreator
    private String segurado;
    private Double valorFIPE;
    private int idadeCondutor;
    private int tempoHabilitacao;
    private Double coberturaTerceiros;
    private String CNH;
    private String CRLV;
    private String comprovanteRes;

    public ContratoApoliceAuto(String segurado, Double valorFIPE, int idadeCondutor, int tempoHabilitacao, Double coberturaTerceiros,
                               String CNH, String CRLV, String comprovanteRes){
        this.segurado = segurado;
        this.valorFIPE = valorFIPE;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacao = tempoHabilitacao;
        this.coberturaTerceiros = coberturaTerceiros;
        this.CNH = CNH;
        this.CRLV = CRLV;
        this.comprovanteRes = comprovanteRes;
    }

    @Override
    protected Apolice criarApolice(){
        return new ApoliceAuto(segurado, valorFIPE, idadeCondutor, tempoHabilitacao, coberturaTerceiros, CNH, CRLV, comprovanteRes);
    }
}
