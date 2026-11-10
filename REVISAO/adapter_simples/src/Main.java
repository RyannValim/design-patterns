import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Target> ambientes = List.of(
            new FornecedorAdapter(new Fornecedor(101, 752)),
            new FornecedorAdapter(new Fornecedor(102, 320)),
            new FornecedorAdapter(new Fornecedor(103, 1000))
        );

        new Painel().exibir(ambientes);
    }
}

/*
Colinha de 60 segundos para a prova
Como identificar: o enunciado trava duas coisas ("já em produção" / "legado,
do fornecedor, não pode ser alterada"). A primeira é o Target, a segunda é o
Adaptee. A classe que o enunciado descreve mas não nomeia é o Adapter. Quem
chama é o Client.

Como escrever: o Adapter tem duas marcas, sempre as duas juntas —
implements Target e um atributo private final Adaptee, recebido no construtor.

Corpo de todo método: converte a entrada → delega ao adaptee → converte a
saída. Zero regra de negócio.

O contrato se escreve na língua de quem consome, nunca na de quem fornece.
Se o nome do método ou o parâmetro do Target menciona algo do fornecedor,
está errado.

Diagrama: adapter ..|> interface (tracejado + triângulo vazado);
adapter →adaptee (linha sólida, seta aberta, 1); client → interface e nunca
para o adaptee.

Discursiva clássica: adaptador de objeto (composição) em vez de classe
(herança), porque Java não tem herança múltipla, porque composição adapta
subclasses do adaptee e permite trocá-lo em execução, e porque herdar vazaria
os métodos do adaptee na interface pública do adapter.
*/