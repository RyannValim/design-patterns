## Singleton

**Núcleo**: quando um objeto muda, <b>vários</b> precisam ser avisados. Quem muda não conhece cada interessado, só uma lista deles.

**Analogia**: canal do YouTube. O canal tem a lista de inscritos e avisa todos quando posta. Você se inscreve ou sai sem o canal mudar.

**Sinal do enunciado**: "notificar", "quando X mudar, atualizar Y e Z", "assinantes/interessados", "alertas".

**Peças**:

- um <b>Subject</b> tem uma lista de <b>Observer</b>, o método <b>attach()</b> e o <b>notifyAllObservers()</b>, que chama <b>update()</b> de cada um;
- o <b>setState()</b> dispara a notificação;
- <b>ConcreteObserver</b> implementa <b>update()</b>.
