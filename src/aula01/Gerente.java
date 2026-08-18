package src.aula01;

public class Gerente extends Funcionario{

    public int numeroDeFuncionariosGerenciados;

    // Sobrescrita
    @Override // -> Sinaliza que o método abaixo precisa ter a mesma assinatura da classe Base.
    public double getBonificacao(){
        // return this.salario * 0.15 + this.numeroDeFuncionariosGerenciados;
        super.salario = 5.00;
        double bonusBase = getBonificacao();
        double bonusAdicional = 0.2 * this.numeroDeFuncionariosGerenciados;
        return bonusBase + bonusAdicional;
    }
}

// Sobrescrita: muda o método, mantém a assinatura.
// Sobrecarga: mantém o método, muda a assinatura.