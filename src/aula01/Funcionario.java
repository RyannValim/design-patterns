package src.aula01;

public class Funcionario{
    protected String nome;
    protected String cpf;
    protected Double salario;
    protected String cargo;

    public Double getBonificacao(){
        return this.salario * 0.15;
    }
}