# Sistema de locação de equipamentos esportivos (S + O + L + I + D)

**Contexto:** a loja "Aventura Radical" aluga equipamentos esportivos por dia. Cada tipo de equipamento calcula o valor da locação de um jeito diferente, e alguns exigem caução.

## Especificação de negócio

- **Bicicleta** — `valorDiaria × diasLocacao`. Não exige caução.
- **PranchaDeSurf** — `(valorDiaria × diasLocacao) + taxaManutencao` (taxa fixa de R$15,00). Exige caução fixa de R$100,00.
- **Kart** — `(valorDiaria × diasLocacao) × 1.2` (acréscimo de 20% de seguro). Exige caução equivalente a 50% do valor total da locação (calculada a partir do próprio `calcularValorLocacao()`).

## Requisitos obrigatórios

1. Classe abstrata `Equipamento`, com campos `protected` `nome` (String), `valorDiaria` (double) e `diasLocacao` (int).
2. `Equipamento` também tem, **concretos** (implementados uma única vez, herdados sem mudança):
   - `setDiasLocacao(int diasLocacao): void`
   - `getDiasLocacao(): int`
3. `Equipamento` declara o método **abstrato** `calcularValorLocacao(): double` — **sem parâmetro**, pois usa o campo interno `diasLocacao` (já configurado via `setDiasLocacao`), não um valor recebido a cada chamada. Essa decisão evita ter duas fontes de verdade diferentes para "quantos dias foram alugados".
4. Três subclasses concretas de `Equipamento`: `Bicicleta`, `PranchaDeSurf`, `Kart` — cada uma implementando `calcularValorLocacao()` conforme a regra de negócio acima.
5. Interface separada `Cautelavel`, com o método `calcularCaucao(): double` (também sem parâmetro, pelo mesmo motivo do item 3). Apenas `PranchaDeSurf` e `Kart` implementam essa interface — `Bicicleta` não.
   - `PranchaDeSurf.calcularCaucao()` devolve o valor fixo da caução.
   - `Kart.calcularCaucao()` chama `calcularValorLocacao()` internamente e devolve 50% do resultado (chamar um método próprio da mesma classe é permitido; o que não pode é depender de algo externo).
6. Classe `ServicoDeLocacao`, com o método `processarLocacao(Equipamento equipamento, int diasLocacao): String`, que:
   - primeiro chama `equipamento.setDiasLocacao(diasLocacao)`,
   - só depois chama `equipamento.calcularValorLocacao()`,
   - e devolve um comprovante em `String` com nome do equipamento + valor calculado.
   - **Nunca** pode instanciar `Bicicleta`, `PranchaDeSurf` ou `Kart` diretamente, nem conter `if`/`else` verificando o tipo recebido.
7. Classe `CalculadoraDeCaucao`, com o método `somarTotalCaucao(Cautelavel[] cautelaveis): double`, que soma o `calcularCaucao()` de cada item do array. Recebe um array de **`Cautelavel`**, não de `Equipamento` — assim nunca precisa checar "esse equipamento tem caução ou não?".
8. Na `Main`: toda criação de objetos concretos (`new Bicicleta()`, `new PranchaDeSurf()`, `new Kart()`) acontece só ali. `PranchaDeSurf` e `Kart` devem ser declaradas com o **tipo concreto** (não `Equipamento`), para poderem entrar tanto em chamadas que esperam `Equipamento` quanto num array `Cautelavel[]`. `Bicicleta` nunca entra nesse array, pois não implementa `Cautelavel`.

## O que cada requisito força

- **S:** `Equipamento`/subclasses só calculam. `ServicoDeLocacao` só processa locação. `CalculadoraDeCaucao` só soma cauções.
- **O:** um novo equipamento (ex. `CaiaqueDeAluguel`) não deve exigir mudança em `ServicoDeLocacao` nem em `CalculadoraDeCaucao`.
- **L:** qualquer `Equipamento` passado para `ServicoDeLocacao` se comporta de forma previsível; qualquer `Cautelavel` sempre devolve uma caução válida.
- **I:** `Bicicleta` não é forçada a implementar `calcularCaucao()`, já que essa capacidade está isolada em `Cautelavel`.
- **D:** `ServicoDeLocacao` e `CalculadoraDeCaucao` dependem só das abstrações (`Equipamento`, `Cautelavel`), nunca de classe concreta.

## Pontos de atenção (erros comuns já mapeados)

- `getDiasLocacao()` não deve receber parâmetro nenhum — é leitura pura de um campo já existente no objeto.
- A ordem de chamadas em `processarLocacao` importa: `setDiasLocacao` **antes** de `calcularValorLocacao()`, ou o cálculo roda com o valor padrão (zero) de `int`.
- Atributos que carregam valores fixos usados em cálculo (como `taxaManutencao` e `valorCaucao` em `PranchaDeSurf`) podem virar campos `private` da própria classe, desde que o diagrama reflita isso.

## Notação UML usada neste exercício

- Herança (`extends`): linha sólida + triângulo vazado.
- Realização (`implements`): linha tracejada + triângulo vazado.
- Dependência: linha tracejada + seta aberta simples.
- Uma classe concreta pode ter, ao mesmo tempo, uma seta de herança (para a superclasse) e uma ou mais setas de realização (para interfaces implementadas) — é o caso de `PranchaDeSurf` e `Kart`.
- Métodos/classes sem implementação (abstratos, de interface) em itálico; métodos concretos em texto normal, mesmo quando definidos dentro de uma classe abstrata (como `setDiasLocacao`/`getDiasLocacao`).
