package apolices;

public class ContratoApoliceVida extends ContratoApolice{ // ConcreteCreator
    private String segurado;
    private int idadeSegurado;
    private Double capitalSegurado;
    private Boolean seguradoFumante;
    private String RG;
    private String CPF;
    private String atestadoMedico;

    public ContratoApoliceVida(String segurado, int idadeSegurado, Double capitalSegurado, Boolean seguradoFumante,
                               String RG, String CPF, String atestadoMedico){
        this.segurado = segurado;
        this.idadeSegurado = idadeSegurado;
        this.capitalSegurado = capitalSegurado;
        this.seguradoFumante = seguradoFumante;
        this.RG = RG;
        this.CPF = CPF;
        this.atestadoMedico = atestadoMedico;
    }

    @Override
    protected Apolice criarApolice(){
        return new ApoliceVida(segurado, idadeSegurado, capitalSegurado, seguradoFumante, RG, CPF, atestadoMedico);
    }
}
