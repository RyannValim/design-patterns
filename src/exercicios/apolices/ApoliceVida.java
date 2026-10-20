package apolices;

import java.util.ArrayList;
import java.util.List;

public class ApoliceVida extends Apolice{ // ConcreteProduct
    private int idadeSegurado;
    private Double capitalSegurado;
    private Boolean seguradoFumante;
    private String RG;
    private String CPF;
    private String atestadoMedico;

    public ApoliceVida(String segurado, int idadeSegurado, Double capitalSegurado, Boolean seguradoFumante,
                       String RG, String CPF, String atestadoMedico){
        super(segurado);
        this.idadeSegurado = idadeSegurado;
        this.capitalSegurado = capitalSegurado;
        this.seguradoFumante = seguradoFumante;
        this.RG = RG;
        this.CPF = CPF;
        this.atestadoMedico = atestadoMedico;
    }

    @Override
    public Double calcPremioMensal(){
        Double totalPM = this.idadeSegurado * 12 + (this.capitalSegurado * 0.002);

        if(this.seguradoFumante){ totalPM *= 1.5; }

        return totalPM;
        /* LÓGICA
            premioMensal == idadeSegurado * 12 + (capital segurado * 0.002)
                se segurado == fumante, + 50% sobre o premioMensal
        */    
    }

    @Override
    public Boolean validarCobertura(){
        if(
            this.capitalSegurado > 500000.00 &&
            this.atestadoMedico == null
        ){ return false; }

        return true;

        // LÓGICA: capitalSegurado acima de 500k exigem atestado médico
    }

    @Override
    public List<String> listarDocumentos(){
        List<String> documentos = new ArrayList<>();

        documentos.add("RG: '" + this.RG + "'");
        documentos.add("CPF: '" + this.CPF + "'");
        if(this.capitalSegurado > 500000.00){ documentos.add("Atestado Médico: '" + this.atestadoMedico + "'"); }

        return documentos;

        // LÓGICA: docs: RG, CPF e atestadoMedico (quando aplicável)
    }

    @Override
    protected String getPrefixo(){ return "VID"; }
}
