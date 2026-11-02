public class RelatorioChile extends Relatorio{
    public RelatorioChile(){
        this.docFiscal = "boleta eletrónica";
        this.taxa = "IVA";
        this.formaPag = "Webpay";
        this.idAluno = "RUT: 291237920";
    }
    
    @Override
    public void imprimirRelatorio(String nomeAluno){
        System.out.println("Id do Aluno: '" + this.idAluno + "'");
        System.out.println("Nome do Aluno: '" + nomeAluno + "'");
        System.out.println("Documento fiscal: '" + this.docFiscal + "'");
        System.out.println("Taxa '" + this.taxa + "': 19%");
        System.out.println("Forma de Pagamento: '" + this.formaPag + "'");
    }
}
