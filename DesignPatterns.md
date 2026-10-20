# Design Patterns

Design Patterns são um kit de ferramentas para soluções tentadas e testadas para problemas comuns em projetos de desenvolvimento de softwares.

---

Este projeto abrange (por enquanto): FactoryMethod, AbstractFactory e Observer.
---

# Factory Method

**Intenção (GoF p. 112):** define uma interface para criar um objeto, mas deixa as **subclasses decidirem que classe instanciar**. O Factory Method permite adiar a instanciação para subclasses.

Também chamado de **Virtual Constructor**.

A frase que resolve a maioria das dúvidas: **o método-fábrica mora dentro do `Creator`, não em uma classe separada.** Quem decide o produto é uma subclasse do próprio `Creator`.

## Use quando

- uma classe **não pode antecipar** a classe de objetos que deve criar;
- uma classe quer que **suas subclasses** especifiquem os objetos que ela cria;
- você delega responsabilidade para uma dentre várias subclasses auxiliares e quer **localizar em um ponto** o conhecimento de qual delas é a delegada.

## Participantes

| Papel (livro) | No exercício | Responsabilidade |
|---|---|---|
| `Product` | `Sender` (interface) | declara a interface do objeto que o método-fábrica cria |
| `ConcreteProduct` | `EmailSender`, `SmsSender`, `PushSender`, `WhatsAppSender`, `TelegramSender` | implementa `Product` |
| `Creator` | `Notifier` (abstrata) | declara o **método-fábrica** (`createSender()`) e tem a **`AnOperation()`** (`alert()`) que chama o método-fábrica e usa o produto |
| `ConcreteCreator` | `EmailNotifier`, `SmsNotifier`, … | **sobrescreve** o método-fábrica para devolver o produto concreto |

Como identificar cada um no código:

- **`FactoryMethod()`** é o método que produz o objeto de que o resto da classe precisa, mas cuja classe concreta a classe mãe **deixa em aberto**. Não é o nome (`create…` é só convenção, p. 118) nem o fato de ser abstrato.
- **`AnOperation()`** é o **trabalho real** do `Creator`, o motivo de a classe existir — e esse trabalho **precisa de um produto**. Chamar o método-fábrica é só o meio de obtê-lo. Pode haver várias.

## Relações (as linhas do diagrama)

| De | Para | Relação | Por quê |
|---|---|---|---|
| cada `XSender` | `Sender` | realização (tracejada + triângulo vazado) | `implements` |
| cada `XNotifier` | `Notifier` | generalização (cheia + triângulo vazado) | `extends` |
| cada `XNotifier` | seu `XSender` | dependência `<<create>>` | `new EmailSender()` dentro do método |
| `Notifier` | `Sender` | dependência `<<use>>` | `Sender` é **tipo de retorno** e **variável local**, nunca atributo |

A figura do livro (p. 113) **não desenha** a seta `Creator ╌╌▸ Product`; é uma simplificação, um diagrama UML completo pode mostrá-la.

## Esqueleto

```java
public interface Sender {                       // Product
    void send(String msg);
}

public class EmailSender implements Sender {    // ConcreteProduct
    public void send(String msg) { /* ... */ }
}

public abstract class Notifier {                // Creator
    protected abstract Sender createSender();   // FactoryMethod: a subclasse decide

    public void alert(String msg) {             // AnOperation: o trabalho que não varia
        Sender sender = createSender();         // "product = FactoryMethod()"
        sender.send(msg);
    }
}

public class EmailNotifier extends Notifier {   // ConcreteCreator
    @Override
    protected Sender createSender() {
        return new EmailSender();               // "return new ConcreteProduct"
    }
}

// Main (a borda): só aqui o texto vira tipo
switch (canal) {
    case "EMAIL": notifier = new EmailNotifier(); break;
    case "SMS":   notifier = new SmsNotifier();   break;
    default: throw new IllegalArgumentException("Canal '" + canal + "' não existe!");
}
notifier.alert("mensagem");
```

## Consequências

- **+ Elimina classes concretas do código que trabalha.** O `Notifier` lida só com a interface `Sender`; funciona com qualquer `ConcreteProduct`, inclusive os que ainda não existem.
- **+ OCP medido:** um canal novo (Telegram) custa **2 arquivos novos** (`TelegramSender`, `TelegramNotifier`) e **0 linhas** em qualquer classe do núcleo. Só a borda muda.
- **+ Ganchos para subclasses** (p. 114): criar o objeto numa operação separada é sempre mais flexível do que criá-lo direto, porque a subclasse pode fornecer uma versão estendida.
- **− Uma subclasse de `Creator` por produto** (p. 114): o cliente pode ter que criar uma subclasse **só** para escolher um produto. Vale a pena quando ele já ia subclassificar de qualquer jeito.
- **− A decisão "texto → tipo" não desaparece**, ela se muda para a borda. A diferença para a forma ingênua é que lá o `if` ficava **dentro da classe que faz o trabalho** e crescia a cada produto; aqui é um ponto só, fora do núcleo.

## Decisões de implementação (p. 115-118)

| Decisão | Opções | Troca |
|---|---|---|
| O `Creator` é abstrato? | (1) abstrato, sem implementação do método-fábrica / (2) concreto, com implementação **por omissão** | (1) obriga a subclasse a decidir — use quando não existe padrão razoável; (2) dá flexibilidade ("criar objetos numa operação separada para subclasses poderem redefinir") sem forçar ninguém |
| Método-fábrica **parametrizado** | `create()` / `create(tipo)` | parametrizado cria vários produtos com um método só, e a subclasse pode estender chamando `super.create(tipo)` no final para o que ela não trata — mas volta o `if` sobre o parâmetro |
| `AnOperation()` pode ser sobrescrita? | sim / `final` | `final` trava o algoritmo e deixa variar **só** o passo da criação. É a decisão de quem quer garantir o fluxo |
| Visibilidade do método-fábrica | `private` / `protected` / `public` | `private` **não é visível na subclasse** → impossível sobrescrever. `protected` é o usual |

## Pegadinhas

- O método-fábrica devolve o **`Product`**, nunca o `Creator`. `createSender()` do `EmailNotifier` devolve `EmailSender` — se devolvesse `EmailNotifier`, o `alert()` não teria `send()` para chamar.
- **O `Creator` não sabe** qual produto veio. O tipo declarado é `Sender` e o nome `EmailSender` não aparece em lugar nenhum dele. Quem executa o `send()` certo é o **polimorfismo**, em tempo de execução.
- **Simple Factory não é Factory Method** e não está no livro. Lá uma classe separada decide o produto com `if/else` sobre um **parâmetro**; aqui quem decide é a **subclasse**, por sobrescrita. O Simple Factory é um caminho didático, não a base técnica do padrão.
- O `Creator` é a classe que **faz um trabalho que precisa do produto** — não uma classe de fábrica criada só para isso. Se o método-fábrica foi parar numa classe separada injetada por construtor, isso é composição (e se aproxima do Abstract Factory), não a figura da p. 113.
- `Factory Method` é como o **Abstract Factory** (p. 95) costuma ser implementado por dentro, e os métodos-fábrica são normalmente chamados dentro de **Template Methods** (p. 301).

**Livro:** p. 112-120 (PDF 106-114 nesta edição). Estrutura e Participantes: p. 113-114. Implementação: p. 115-118.

**Código:** `src/notification/normal` (acoplado) × `src/notification/simplefactory` (passo intermediário) × `src/notification/factorymethod` (padrão).

---

# Observer

**Intenção (GoF p. 274):** define uma dependência **um-para-muitos** entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente.

Também chamado de **publish/subscribe**: o subject publica sem saber quem são os assinantes; qualquer número de observadores se inscreve.

## Use quando

- uma mudança em um objeto exige mudanças em outros e **você não sabe quantos**;
- um objeto deve notificar outros **sem fazer hipóteses sobre quem eles são**;
- dois aspectos dependentes precisam variar e ser reutilizados separadamente.

## Participantes

| Papel (livro) | No exercício | Responsabilidade |
|---|---|---|
| `Subject` | `Subject` (interface) | mecanismo de inscrição: `inscrever`, `desinscrever`, `notificar` |
| `ConcreteSubject` | `Pedido` | guarda **o estado** e a **lista de observadores**; notifica quando o estado muda |
| `Observer` | `Observer` (interface) | declara `update()` — o contrato |
| `ConcreteObserver` | `Auditoria`, `AvisoCliente`, `PainelCozinha`, `EnvioEntregador`, `NotaFiscal` | implementa `update()` e **reage do seu jeito** |

Regra que resolve a maioria das dúvidas: **o estado mora no ConcreteSubject, nunca na interface `Subject`** — a interface só carrega o mecanismo de inscrição.

## Relações (as linhas do diagrama)

| De | Para | Relação | Por quê |
|---|---|---|---|
| `Pedido` | `Subject` | realização (tracejada + triângulo vazado) | `implements` |
| cada observador | `Observer` | realização | `implements` |
| `Pedido` | `Observer` | associação `1` — `*` | atributo `List<Observer>` |
| `Subject` | `Observer` | dependência `<<use>>` | `Observer` é **parâmetro** de `inscrever`/`desinscrever` |
| `Observer` | `Subject` | dependência `<<use>>` | só existe se `update` receber o subject |
| cada observador | `Pedido` | associação `1` (só no pull) | atributo `Pedido` recebido no construtor |

Critério: **atributo → associação; parâmetro ou variável local → dependência `<<use>>`; `new` dentro + não sobrevive ao todo → composição (losango preenchido).**

## Esqueleto (versão pull)

```java
public interface Subject {
    void inscrever(Observer o);
    void desinscrever(Observer o);
    void notificar();
}

public interface Observer {
    void update(Subject s);
}

public class Pedido implements Subject {
    private String status;
    private List<Observer> observadores = new ArrayList<>();

    public void inscrever(Observer o)    { observadores.add(o); }
    public void desinscrever(Observer o) { observadores.remove(o); }
    public void notificar() { for (Observer o : observadores) o.update(this); }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; notificar(); }
}

public class Auditoria implements Observer {
    private String statusObserver;
    private Pedido p;
    public Auditoria(Pedido p) { this.p = p; }

    public void update(Subject s) {
        this.statusObserver = p.getStatus();          // pull: o observador busca
        System.out.println("[LOG] status: " + statusObserver);
    }
}

// Main (a borda): cria, inscreve, muda o estado
Pedido p = new Pedido();
p.inscrever(new Auditoria(p));
p.setStatus("Pedido pronto");
```

## Consequências

- **+ Acoplamento abstrato:** o subject só conhece `Observer`. Não sabe a classe concreta de ninguém.
- **+ Broadcast:** a notificação não escolhe destinatário; **é responsabilidade do observador tratar ou ignorar** (o `if` fica dentro do observador, nunca no subject).
- **+ OCP medido:** acrescentar um interessado custa **0 linhas** no `Pedido` (só um arquivo novo + a borda). Na versão acoplada custa 3 linhas dentro do `Pedido`.
- **− Atualizações inesperadas:** ninguém vê o custo total de uma mudança; uma operação inócua pode disparar cascata e atualizações espúrias.

## Decisões de implementação (p. 277-280)

| Decisão | Opções | Troca |
|---|---|---|
| Quem dispara `notificar()` | (a) o próprio `setStatus` / (b) o cliente | (a) ninguém esquece, mas todo estado intermediário dispara reação (a nota fiscal sai antes do cancelamento); (b) dá para agrupar, mas alguém vai esquecer — e o esquecimento é **silencioso** |
| Quanta informação viaja | **pull** `update(Subject s)` / **push** `update(String status)` | pull: o subject não supõe nada, o observador busca o que quer. push: mais direto, mas mudar o que se envia obriga a editar **todos** os observadores, inclusive os que não usam o dado. **Pull não é polling** — nos dois casos quem acorda o observador é a notificação |
| `update` recebe o subject | sim / não | só vale a pena quando um observador acompanha **mais de um** subject: `s` diz qual mudou |

Na variante **push** sem o subject (`update(String status)`), os observadores perdem o campo `Pedido`, o construtor e a associação no diagrama, e some também a dependência `Observer ╌╌▸ Subject` — sobra **uma** seta `<<use>>`, a de `Subject` para `Observer`. O preço: o observador não tem mais como saber *qual* subject mudou.

## Pegadinhas

- Campo declarado em `interface` é implicitamente `public static final` → vira **uma lista única** compartilhada por todos os subjects. Lista de observadores **nunca** vai na interface.
- `private Pedido p` sem construtor que o preencha → `NullPointerException` na primeira notificação.
- `update()` é `void`: o observador **reage**, não responde. Se devolvesse valor, o subject teria que saber o que fazer com ele — e aí voltaria o `if/else` por tipo.
- A lista é `List<Observer>`, nunca `List<Auditoria>`: objeto concreto, visão abstrata.

**Livro:** p. 274-283 (PDF 268-277 nesta edição). Notação do livro é OMT, não UML — Apêndice B, p. 333-337.

**Código:** `src/pedido/normal` (acoplado) × `src/pedido/observer` (padrão).
