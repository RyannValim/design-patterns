package pedidos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class PedidosApp {
    private static void imprimir(Pedido p) {
        System.out.printf(Locale.of("pt", "BR"),
            "Pedido #%d | %s | %s | itens=%d | total=R$ %.2f%n",
            p.getId(), p.getCliente(), p.getEnderecoEntrega(),
            p.getItens().size(), p.valorTotal()
        );
    }

    private static void verificar(String descricao, boolean passou) {
        if (passou) {
            System.out.println(descricao + ": OK");
        } else {
            System.out.println(descricao + ": FALHA");
        }
    }

    private static boolean compartilhaItem(Pedido copia, Pedido modelo) {
        for (ItemPedido itemCopia : copia.getItens()) {
            for (ItemPedido itemModelo : modelo.getItens()) {
                if (itemCopia == itemModelo) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        // criando itens do pedido
        ItemPedido cafe = new ItemPedido(
            "Café 500g", 10, new BigDecimal("18.90")
        );
        
        ItemPedido acucar = new ItemPedido(
            "Açúcar 1kg", 20, new BigDecimal("4.50")
        );
        
        ItemPedido filtroDePapel = new ItemPedido(
            "Filtro de papel", 5, new BigDecimal("7.20")
        );
        
        // adicionando o pedido
        Pedido pedidoModelo = new Pedido("(modelo)", "-");
        pedidoModelo.adicionar(cafe);
        pedidoModelo.adicionar(acucar);
        pedidoModelo.adicionar(filtroDePapel);
        
        // adicionando o pedido no catalogo de pedidos
        CatalogoDePedidos catalogoDePedidos = new CatalogoDePedidos();
        catalogoDePedidos.registrar("reposicao-mensal", pedidoModelo);

        // pedidoA
        Pedido pedidoA = catalogoDePedidos.criar("reposicao-mensal");
        pedidoA.setCliente("Mercado Central");
        pedidoA.setEnderecoEntrega("Rua das Flores, 120");

        // pedidoB
        Pedido pedidoB = catalogoDePedidos.criar("reposicao-mensal");
        pedidoB.setCliente("Padaria Boa Massa");
        pedidoB.setEnderecoEntrega("Av. Paraná, 800");
        pedidoB.getItens().get(0).setQuantidade(20);
        
        // pedidoC
        Pedido pedidoC = catalogoDePedidos.criar("reposicao-mensal");
        pedidoC.setCliente("Restaurante do Porto");
        pedidoC.setEnderecoEntrega("Rua do Cais, 45");
        pedidoC.adicionar(new ItemPedido("Adoçante 100ml", 12, new BigDecimal("6.00")));
    
        // imprimindo
        imprimir(pedidoModelo);
        imprimir(pedidoA);
        imprimir(pedidoB);
        imprimir(pedidoC);

        // teste 1
        verificar("CA-04 modelo continua com 3 itens", pedidoModelo.getItens().size() == 3);

        // teste 2
        verificar("CA-07 cliente do modelo preservado", pedidoModelo.getCliente().equals("(modelo)"));
    
        // teste 3
        verificar("CA-02 modelo continua 315,00",
            pedidoModelo.valorTotal().compareTo(new BigDecimal("315.00")) == 0
        );

        // teste 4
        verificar("CA-03 totais A/B/C corretos",
            pedidoA.valorTotal().compareTo(new BigDecimal("315.00")) == 0
            && pedidoB.valorTotal().compareTo(new BigDecimal("504.00")) == 0
            && pedidoC.valorTotal().compareTo(new BigDecimal("387.00")) == 0
        );

        // teste 5
        Set<Long> ids = new HashSet<>();
        ids.add(pedidoModelo.getId());
        ids.add(pedidoA.getId());
        ids.add(pedidoB.getId());
        ids.add(pedidoC.getId());

        verificar("CA-01 ids diferentes", ids.size() == 4);

        // teste 6
        boolean lancou;

        try {
            catalogoDePedidos.criar("inexistente");
            lancou = false;
        } catch (IllegalArgumentException e) {
            lancou = true;
        }

        verificar("CA-06 chave inexistente lança exceção", lancou);

        // teste 7
        verificar("CA-05 itens não compartilhados",
            !compartilhaItem(pedidoA, pedidoModelo)
            && !compartilhaItem(pedidoB, pedidoModelo)
            && !compartilhaItem(pedidoC, pedidoModelo)
        );
    }
}
