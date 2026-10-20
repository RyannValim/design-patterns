package apolices;

import java.util.ArrayList;
import java.util.List;

public class ApoliceViagem extends Apolice{ // ConcreteProduct
    private String destinoViagem; // NACIONAL ou INTERNACIONAL
    private int diasViagem;
    private Double valorCoberturaMedica;
    private String passaporte;
    private String itinerarioViagem;

    public ApoliceViagem(String segurado, String destinoViagem, int diasViagem, Double valorCoberturaMedica,
                         String passaporte, String itinerarioViagem){
        super(segurado);
        this.destinoViagem = destinoViagem;
        this.diasViagem = diasViagem;
        this.valorCoberturaMedica = valorCoberturaMedica;
        this.passaporte = passaporte;
        this.itinerarioViagem = itinerarioViagem;
    }
    
    @Override
    public Double calcPremioMensal(){
        Double totalPM = this.diasViagem * 15.00;

        if(this.isInternacional()){ totalPM += 100.00; }
        
        return totalPM;
        
        /* LÓGICA
            premioMensal == (diasViagem * R$15)
                se viagemInternacional, + R$100,00
        */
    }

    @Override
    public Boolean validarCobertura(){
        if(
            this.isInternacional() &&
            (this.valorCoberturaMedica < 30000.00 || this.passaporte == null)
        ){ return false; }

        return true;
        
        /* LÓGICA
            viagemInternacional exige cobertura de assistência médica >= U$30k
               + apresentação de passaporte
        */
    }

    @Override
    public List<String> listarDocumentos(){
        List<String> documentos = new ArrayList<>();

        documentos.add("Itinerário de Viagem: '" + this.itinerarioViagem + "'");
        if(this.isInternacional()){ documentos.add("Passaporte: '" + this.passaporte + "'"); }

        return documentos;
        
        // LÓGICA: docs: itinerário de viagem e passaporte (quando aplicável)
    }

    @Override
    protected String getPrefixo(){ return "VIA"; }

    private Boolean isInternacional(){
        return this.destinoViagem.equals("INTERNACIONAL");
    }
}
