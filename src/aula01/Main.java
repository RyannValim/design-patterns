package src.aula01;

public class Main{
    public static void main(String[] args){
        Gerente coord = new Gerente();
        coord.nome = "Araci de Almeida";
        coord.salario = 10000.00;
        coord.numeroDeFuncionariosGerenciados = 10;

        Gerente coord1 = new Gerente();
        coord1.nome = "Pedro de Lara";
        coord1.salario = 8000.00;
        coord1.numeroDeFuncionariosGerenciados = 5;

        Operador porteiro = new Operador();
        porteiro.nome = "Leandro Escobar";
        porteiro.salario = 1500.00;

        Financeiro fin = new Financeiro();
        fin.computaBonus(coord);
        fin.computaBonus(coord1);
        fin.computaBonus(porteiro);

        Funcionario funcGerente = new Gerente();
        funcGerente.nome = "Silvio Santos";
        funcGerente.salario = 20000.00;

        // Saídas
        System.out.printf("Bonificação de %s: %s\n", coord.nome, coord.getBonificacao());
        System.out.printf("Bônus Total %s: %s\n", porteiro.nome, fin.getTotalBonus());
        System.out.printf("Salário do %s: %s\n", funcGerente.nome, funcGerente.getBonificacao());
    }
}

/* PARA RODAR EM LINUX:

    Primeiro compilar os pacotes com "javac -d", "bin" para sinalizar a pasta de saída, "src/aula01/*.java" para sinalizar os '.java'. 
    - javac -d bin src/aula01/*.java

    Depois rodar o compilado com "java -cp" apontando o pacote em "bin src/aula01.Main".
    - java -cp bin src/aula01.Main
*/

// Acomplagem: Quando um objeto é muito dependente de outro.