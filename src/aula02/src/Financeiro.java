package aula02.src;

public class Financeiro{
    private double totalBonus = 0.00;

    public double getTotalBonus(){
        return this.totalBonus;
    }

    public void computaBonus(Funcionario funcionario){
        double bonus = funcionario.getBonificacao();
        this.totalBonus += bonus;
        System.out.printf("'%s' receberá um bônus de R$%.2f!\n", funcionario.nome, bonus);
    }
}