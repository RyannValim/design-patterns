## Adapter

**Núcleo**: existe uma classe pronta que você não pode mudar e que não tem o formato que seu sistema espera. Você põe um tradutor no meio.

**Analogia**: adaptador de tomada.

**Sinal do enunciado**: "legado", "fornecedor/terceiro""não podem ser alteradas", "assinaturas, unidades ou formatos diferentes".

**Peças**: Client usa *\<interface\> Target*. O adapter implementa Target e tem um *Adaptee*. Cada método do Adapter converte e repassa a chamada.


Papel	| Quem é
Client	| quem precisa do serviço e vai fazer a chamada
Target	| a forma como o Client sabe pedir — um contrato, não uma implementação
Adaptee	| quem já sabe fazer o serviço, mas atende de outro jeito
Adapter	| o tradutor, a única peça que você escreve