package aula02.src;

public abstract class Funcionario{
    protected String nome;
    protected String cpf;
    protected double salario;
    protected String senha;

    public boolean autentica(String senha){
        return senha.equals(this.senha);
    }

    public abstract double getBonificacao();
}
