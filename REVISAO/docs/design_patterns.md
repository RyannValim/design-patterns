#### Padrões Criacionais respondem "como o objeto nasce?":

- Factory Method.
- Abstract Factory.
- Singleton.
- Prototype.

---

#### Padrões Estruturais respondem "como encaixar objetos?":

- Adapter.

---

#### Padrões Comportamentais respondem "como objetos agem e se avisam?":

- Observer.
- Strategy.

---

#### Pares que confundem

- **Strategy x Adapter**: o diagrama é quase igual. No Strategy, você criou tudo para **trocar comportamento**. No Adapter, a classe já existia, não é sua e precisa caber num contrato que já existe.
- **Strategy x Factory**: Strategy decide **como fazer**; Factory decide **qual objeto criar**.
- **Prototype x Factory**: a fábrica **monta do zero**; o Prototype **copia um objeto pronto**.

| O que varia | Padrão |
|---|---|
| o **algoritmo** (como calcular, como fazer) | Strategy |
| qual **classe** instanciar | Factory Method |
| uma **família** que precisa combinar | Abstract Factory |
| os **dados** de um objeto quase igual a um modelo | Prototype |
| **quantos** existem (só um) | Singleton |
| **quem** precisa ser avisado | Observer |
| a **interface** de algo pronto que você não pode mudar | Adapter |

