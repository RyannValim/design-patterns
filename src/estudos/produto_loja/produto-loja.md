# Sistema de descontos de uma loja (S + O)

**Contexto:** uma loja quer calcular o preço final de produtos diferentes, cada um com sua própria regra de desconto.

## Requisitos obrigatórios

1. Classe abstrata `Produto`, com campos `protected` `nome` (String) e `precoBase` (double), e um método abstrato `calcularPrecoFinal(): double`.
2. Três subclasses concretas:
   - `ProdutoComum` — sem desconto (preço final = preço base).
   - `ProdutoPromocional` — 10% de desconto (`precoBase * 0.90`).
   - `ProdutoLiquidacao` — 30% de desconto (`precoBase * 0.70`).
3. Classe `Carrinho`, com um método `calcularTotal(Produto[] produtos): double` que soma o `calcularPrecoFinal()` de cada item — **sem nenhum `if`/`else` verificando o tipo do produto**.
4. Classe **separada** `ImpressoraRecibo`, com um método `imprimirRecibo(Produto[] produtos): String` que monta (não imprime direto) um texto com nome + preço final de cada produto, um por linha (separados por `\n`), e devolve essa `String` para quem chamou decidir o que fazer com ela.
5. Classe de teste (`Main`) que cria ao menos 3 produtos (misturando os 3 tipos), monta o array, chama `Carrinho.calcularTotal(...)` e `ImpressoraRecibo.imprimirRecibo(...)` com o **mesmo array**, sem que uma classe conheça a outra.

## O que cada requisito força

- **S (Single Responsibility):** `Produto`/subclasses só calculam preço. `Carrinho` só soma. `ImpressoraRecibo` só monta texto. Nenhuma responsabilidade cruzada.
- **O (Open/Closed):** adicionar um novo tipo de produto (ex. `ProdutoImportado`) não deve exigir alteração em `Carrinho` nem em `ImpressoraRecibo` — só a criação da nova subclasse.

## Notação UML usada neste exercício

- Herança (`extends`): linha sólida + triângulo vazado, apontando para a classe-mãe.
- Dependência (uso como parâmetro, sem guardar referência): linha tracejada + seta aberta simples.
- Classe abstrata: estereótipo `<<abstract>>` acima do nome; nome da classe e método(s) abstrato(s) em itálico (quando a ferramenta permitir) ou apenas o estereótipo em texto.
- `Carrinho` e `ImpressoraRecibo` não têm relação direta entre si — cada uma depende só de `Produto`.
