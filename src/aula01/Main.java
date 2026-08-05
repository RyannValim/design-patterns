package src.aula01;

public class Main{
    public static void main(String[] args){
        Gerente gerente01 = new Gerente();
        gerente01.salario = 3000.00;
        
        Double bonificacao = gerente01.getBonificacao();

        System.out.printf("Bonificação: %s\n", bonificacao);
    }
}