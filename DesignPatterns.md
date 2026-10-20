# Design Patterns

Design Patterns são um kit de ferramentas para soluções tentadas e testadas para problemas comuns em projetos de desenvolvimento de softwares.

---

Este projeto abrange (por enquanto): FactoryMethod, AbstractFactory e Observer.
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
