package apolices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
    4 linhas de produto
    Automóvel
    Residencial
    Vida
    Viagem
    
    Na adição de uma 5°, não pode ferir Open/Closed
*/

public abstract class Apolice{ // Product
    private static int contador = 0;

    private String numero;
    private String segurado;
    private LocalDate dataEmissao;

    public Apolice(String segurado){
        this.segurado = segurado;
    }

    public abstract Double calcPremioMensal();
    public abstract Boolean validarCobertura();
    public abstract List<String> listarDocumentos();
    protected abstract String getPrefixo(); // AUTO, RES, VID, VIA

    // RNF02: toda apólice emitida recebe um número único, prefixado conforme o tipo
    public void emitir(){
        contador++;
        this.numero = this.getPrefixo() + "-" + String.format("%05d", contador);
        this.dataEmissao = LocalDate.now();
    }

    // RNF03: resumo textual padronizado para toda contratação bem-sucedida
    public String gerarResumo(){
        StringBuilder resumo = new StringBuilder();

        resumo.append("==========================================\n");
        resumo.append("Apólice: " + this.numero + "\n");
        resumo.append("Segurado: " + this.segurado + "\n");
        resumo.append("Data de emissão: " + this.dataEmissao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
        resumo.append("Prêmio mensal: " + String.format("R$ %.2f", this.calcPremioMensal()) + "\n");
        resumo.append("Documentos exigidos:\n");
        for(String documento : this.listarDocumentos()){ resumo.append("  - " + documento + "\n"); }
        resumo.append("==========================================");

        return resumo.toString();
    }

    public String getSegurado(){ return this.segurado; }
    public String getNumero(){ return this.numero; }
}
