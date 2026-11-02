public class RelatorioBrasil extends Relatorio{
    public RelatorioBrasil(){
        this.docFiscal = "NFS-e";
        this.taxa = "ISS";
        this.formaPag = "PIX";
        this.idAluno = "CPF: 209.123.379-20";
    }

    @Override
    public void imprimirRelatorio(String nomeAluno){
        System.out.println("Id do Aluno: '" + this.idAluno + "'");
        System.out.println("Nome do Aluno: '" + nomeAluno + "'");
        System.out.println("Documento fiscal: '" + this.docFiscal + "'");
        System.out.println("Taxa '" + this.taxa + "': 5%");
        System.out.println("Forma de Pagamento: '" + this.formaPag + "'");
    }
}
