# Sistema de pagamento de um checkout (L + I + D)

**Contexto:** um e-commerce processa pagamentos por Pix, Cartão de Crédito e Boleto. Só o Cartão de Crédito permite estorno.

## Requisitos obrigatórios

1. Interface `FormaPagamento`, com o método `processarPagamento(double valor): String`, que devolve um comprovante em texto (ex.: `"Pagamento via PIX realizado no valor de R$10.0"`).
2. Interface **separada** `Reembolsavel`, com o método `estornar(double valor): String` (mesmo padrão de retorno de `processarPagamento` — devolve o comprovante, não imprime direto).
3. Três classes:
   - `Pix` e `Boleto` implementam **apenas** `FormaPagamento`.
   - `CartaoCredito` implementa `FormaPagamento` **e** `Reembolsavel` (`implements FormaPagamento, Reembolsavel`).
4. Classe `ProcessadorDeCheckout`, com um método `finalizarPagamento(FormaPagamento forma, double valor): void` que chama `forma.processarPagamento(valor)` e imprime o retorno (`System.out.println(forma.processarPagamento(valor))`). Essa classe **nunca** pode conter `new Pix()`, `new Boleto()` ou `new CartaoCredito()` — quem decide e instancia é a `Main`.
5. Nenhum `processarPagamento()` pode lançar erro ou se comportar de forma inesperada quando chamado através da interface `FormaPagamento` — todos devem sempre devolver um comprovante válido.
6. Na `Main`: instanciar `Pix`, `Boleto` e `CartaoCredito` (esta última declarada com o **tipo concreto**, `CartaoCredito`, não `FormaPagamento`, para permitir chamar `estornar()` na mesma variável depois), chamar `processador.finalizarPagamento(...)` para as três, e chamar `formaCartaoCredito.estornar(valor)` separadamente, imprimindo o retorno com `System.out.println(...)`.

## O que cada requisito força

- **L (Liskov):** qualquer `FormaPagamento` passada para `finalizarPagamento()` funciona de forma previsível — nenhuma implementação surpreende quem trata o objeto pela abstração.
- **I (Interface Segregation):** `Pix` e `Boleto` não são forçados a implementar `estornar()`, porque essa capacidade foi isolada em `Reembolsavel`, implementada só por quem precisa.
- **D (Dependency Inversion):** `ProcessadorDeCheckout` (alto nível) depende só da abstração `FormaPagamento`, nunca de uma classe concreta.

## Pontos de atenção (erros comuns já mapeados)

- Uma variável declarada como `FormaPagamento` só permite chamar métodos de `FormaPagamento`, mesmo que o objeto real seja um `CartaoCredito` com `estornar()` — o compilador olha o **tipo declarado**, não o tipo real do objeto. Por isso `formaCartaoCredito` precisa ser declarada como `CartaoCredito`.
- `new FormaPagamento()` e `new Reembolsavel()` nunca compilam — interfaces não podem ser instanciadas, só implementadas por classes concretas.

## Notação UML usada neste exercício

- Realização (`implements`): linha **tracejada** + triângulo **vazado** (diferente de herança, que é linha sólida).
- Interface: estereótipo `<<interface>>`; nome da interface e todos os seus métodos em itálico (todo método de interface é implicitamente abstrato).
- Dependência (`ProcessadorDeCheckout` → `FormaPagamento`): linha tracejada + seta aberta simples (sem triângulo).
