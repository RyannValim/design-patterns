package apolices;

import java.util.ArrayList;
import java.util.List;

public class ApoliceRes extends Apolice{ // ConcreteProduct
    private Double valorImovel;
    private String tipoImovel;
    private String escritura;
    private String contratoLocacao;
    private String comprovanteRes;

    public ApoliceRes(String segurado, Double valorImovel, String tipoImovel, String escritura, String contratoLocacao,
                      String comprovanteRes){
        super(segurado);
        this.valorImovel = valorImovel;
        this.tipoImovel = tipoImovel;
        this.escritura = escritura;
        this.contratoLocacao = contratoLocacao;
        this.comprovanteRes = comprovanteRes;
    }

    @Override
    public Double calcPremioMensal(){
        Double totalPM = this.valorImovel * 0.015 / 12;

        if(this.tipoImovel.equals("ALTO PADRAO")){ totalPM *= 1.25; }

        return totalPM;

        /* LÓGICA
            premioMensal == 1,5% do valor do imóvel ao ano / 12
                se imovel == altoPadrao, + 25% sobre o premioMensal
        */
    }

    @Override
    public Boolean validarCobertura(){
        if(
            this.escritura == null &&
            this.contratoLocacao == null
        ){ return false; }
        
        return true;

        // LÓGICA: escritura ou contrato de locação exigidos
    }

    @Override
    public List<String> listarDocumentos(){
        List<String> documentos = new ArrayList<>();

        if(this.escritura != null){ documentos.add("Escritura: '" + this.escritura + "'"); }
        if(this.contratoLocacao != null){ documentos.add("Contrato Locação: '" + this.contratoLocacao + "'"); }
        documentos.add("Comprovante Residência: '" + this.comprovanteRes + "'");

        return documentos;
        
        // LÓGICA: docs: escritura ou contrato de locação e comprovanteRes
    }

    @Override
    protected String getPrefixo(){ return "RES"; }
}
