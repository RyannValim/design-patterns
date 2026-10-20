package apolices;

import java.util.List;

public class ApoliceAuto extends Apolice{ // ConcreteProduct
    private Double valorFIPE;
    private int idadeCondutor;
    private int tempoHabilitacao;
    private Double coberturaTerceiros;
    private String CNH;
    private String CRLV;
    private String comprovanteRes;

    public ApoliceAuto(String segurado, Double valorFIPE, int idadeCondutor, int tempoHabilitacao, Double coberturaTerceiros,
                       String CNH, String CRLV, String comprovanteRes){
        super(segurado);
        this.valorFIPE = valorFIPE;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacao = tempoHabilitacao;
        this.coberturaTerceiros = coberturaTerceiros;
        this.CNH = CNH;
        this.CRLV = CRLV;
        this.comprovanteRes = comprovanteRes;
    }

    @Override
    public Double calcPremioMensal(){
        Double totalPM = this.valorFIPE * 0.08 / 12;

        if(this.idadeCondutor < 25){ totalPM *= 1.3; }
        if(this.tempoHabilitacao < 2){ totalPM *= 1.2; }

        return totalPM;

        /* LÓGICA
            premioMensal == 8% da FIPE / 12
                se condutor < 25 anos, + 30% sobre premioMensal
                se habilitacao < 2 anos, + 20% sobre o premioMensal
        */
    }

    @Override
    public Boolean validarCobertura(){
        if(
            this.coberturaTerceiros < 50000.00
        ){ return false; }

        return true;

        // LÓGICA: cobertura contratada contra terceiros em R$50k
    }

    @Override
    public List<String> listarDocumentos(){
        return List.of(
            "CNH: '" + this.CNH + "'",
            "CRLV: '" + this.CRLV + "'",
            "Comprovante Residência: '" + this.comprovanteRes + "'"
        );

        // LÓGICA: docs: CNH, CRLV e comprovanteRes
    }

    @Override
    protected String getPrefixo(){ return "AUTO"; }
}
