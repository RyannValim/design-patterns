package src.aula01;

public abstract class Funcionario{

    protected String nome;
    protected String cpf;
    protected Double salario;
    protected String senha;

    public abstract double getBonificacao();

    public boolean autentica(){
        return this.senha.equals(senha);
    }
}