package src.aula01;

public class Financeiro {

    private double totalBonus = 0.0;

    public void computaBonus(Gerente gerente){
        this.totalBonus += gerente.getBonificacao();
    }

    public void computaBonus(Operador operador){
        this.totalBonus += operador.getBonificacao();
    }

    public double getTotalBonus(){
        return this.totalBonus;
    }
}