## Prototype

**Núcleo**: criar do zero é caro ou repetitivo, e você já tem um modelo pronto. Pede para ele se copiar e ajusta a cópia.

**Analogia**: abrir um documento modelo e "Salvar como".

**Sinal do enunciado**: "modelo", "quase idêntico", "mudando apenas", "pré-configurado", "a partir de".

**Peças**: *\<\<interface>> Prototype\<T>* com <b>clonar()</b>; a classe concreta implementa. O <b>Registry</b>, opcional, guarda os modelos e <b>sempre devolve cópia</b>.

**Armadilha**: cópia rasa x profunda.
- na rasa, a cópia aponta para a <b>mesma</b> lista de itens do modelo, então mexer na cópia estraga o modelo;
- na profunda, a cópia recebe uma lista nova, com itens novos.