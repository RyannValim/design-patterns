## Strategy

**Núcleo**: Várias formas de fazer a mesma tarefa. Cada foram vira uma classe, e quem usa só conhece a interface, então pode trocar a forma.

**Analogia GPS**: o destino é o mesmo, e vocÊ troca entre rota rápida, sem pedágio ou a pé.

**Sinal no enunciado**: "modalidades com regras de cálculo diferentes", "acrescentar novas sem alterar", "trocar a qualquer momento", "sem if/switch sobre o tipo".

**Peças**: Context tem um *<\<interface\>> Strategy*, e as estratégias concretas implementam essa interface.
