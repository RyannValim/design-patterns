package aula02.src;

public class Gerente extends Funcionario{
    private int numeroDeFuncionariosGerenciados;

    public void setNumeroDeFuncionariosGerenciados(int numeroFuncionarios){
        this.numeroDeFuncionariosGerenciados = numeroFuncionarios;
    }

    @Override
    public double getBonificacao(){
        return numeroDeFuncionariosGerenciados * 0.2;
    }
}
