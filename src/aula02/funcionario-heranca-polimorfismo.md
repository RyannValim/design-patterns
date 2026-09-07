# Sistema de folha de pagamento (Aula 02: Herança + Polimorfismo)

**Contexto:** uma empresa quer calcular a bonificação de diferentes tipos de funcionário, cada um com sua própria regra de cálculo, e depois somar o total pago em bônus.

Baseado no material da Aula 02 (`funcionario`/`gerente`/`operador`/`financeiro`), mas com nomes e regras revisados.

## Requisitos obrigatórios

1. Classe abstrata `Funcionario`, com campos `protected` `nome` (String), `cpf` (String), `salario` (double) e `senha` (String).
2. Método **concreto** `autentica(String senha): boolean`, implementado uma única vez em `Funcionario`, que compara o parâmetro recebido com o campo `senha` do próprio objeto e devolve `true`/`false`. Herdado sem mudanças por todas as subclasses.
3. Método **abstrato** `getBonificacao(): double` em `Funcionario` — cada subclasse concreta implementa sua própria regra.
4. Subclasse `Gerente`, com atributo próprio `numeroDeFuncionariosGerenciados` (int). Bonificação = **20% do número de funcionários gerenciados** (`0.2 * numeroDeFuncionariosGerenciados`) — sem nenhuma relação com `salario`.
5. Subclasse `Operador`, sem atributo próprio. Diferente do PDF original (que deixava `getBonificacao()` sem implementar, causando erro de compilação), aqui `Operador` **precisa** implementar `getBonificacao()` validamente — retornando `0`, já que operadores não recebem bônus adicional.
6. Classe `Financeiro`, com um campo interno para acumular o total pago em bônus, um método `computaBonus(Funcionario funcionario): void` que soma `funcionario.getBonificacao()` ao total, e um método `getTotalBonus(): double` que devolve o total acumulado.
7. Na `Main`: criar ao menos dois `Gerente` e um `Operador`, passar todos por `Financeiro.computaBonus(...)`, e imprimir o total ao final.
8. **Prática de polimorfismo:** declarar pelo menos uma variável do tipo `Funcionario` guardando um objeto `Gerente` (upcasting) e chamar `getBonificacao()` através dela, observando que a versão executada é a de `Gerente`, mesmo a variável sendo do tipo da superclasse.

## Ponto de atenção (armadilha do material original)

No PDF da Aula 02, o `getBonificacao()` de `Gerente` sobrescrevia `salario` com um valor fixo como efeito colateral (`super.salario = 5`) — isso é uma violação de Liskov: um método com nome de "getter" não deveria alterar o estado do objeto de forma inesperada para quem o chama através da abstração `Funcionario`. Neste exercício, `getBonificacao()` deve **apenas calcular e devolver** o valor da bonificação, sem modificar `salario` nem nenhum outro campo.

## Notação UML usada neste exercício

- Herança (`extends`): linha sólida + triângulo vazado, de `Gerente` e `Operador` até `Funcionario`.
- Classe abstrata: estereótipo `<<abstract>>`; `getBonificacao()` em itálico (abstrato); `autentica()` em texto normal (concreto), mesmo estando dentro da classe abstrata.
- `Financeiro` depende de `Funcionario` apenas como parâmetro de método (não guarda referência) → dependência: linha tracejada + seta aberta simples.
