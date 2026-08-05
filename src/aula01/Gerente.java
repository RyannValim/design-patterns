package src.aula01;

public class Gerente extends Funcionario{
    // Sobrescrita
    @Override
    public Double getBonificacao(){
        return this.salario * 0.15 + 2;
    }
}

// Sobrescrita: mantém o método, mantém a assinatura
// Sobrecarga: mantém o método, muda a assinatura