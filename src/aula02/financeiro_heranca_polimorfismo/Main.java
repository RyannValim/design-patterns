package aula02.financeiro_heranca_polimorfismo;

public class Main {
    public static void main(String[] args){
        // Gerente 1
        Gerente ger1 = new Gerente();
        ger1.nome = "Cleber da Silva";
        ger1.cpf = "023.312.456-92";
        ger1.salario = 7500.00;
        ger1.senha = "ger1@231";
        ger1.setNumeroDeFuncionariosGerenciados(17);

        // Gerente 2
        Gerente ger2 = new Gerente();
        ger2.nome = "Marcio do Que";
        ger2.cpf = "173.566.478-27";
        ger2.salario = 6800.00;
        ger2.senha = "catraca123";
        ger2.setNumeroDeFuncionariosGerenciados(12);

        // Operador
        Operador op = new Operador();
        op.nome = "Marcelo";
        op.cpf = "831.251.995-68";
        op.salario = 2541.00;
        op.senha = "M4rc3l0";

        // Cálculos do Financeiro
        Financeiro financeiro = new Financeiro();
        financeiro.computaBonus(ger1);
        financeiro.computaBonus(ger2);
        financeiro.computaBonus(op);
    }
}
