package checkout;

import java.util.List;

public class Main{
    private static void finalizar(CheckoutFactory factory, Pedido pedido){
        try{
            Checkout checkout = new Checkout(factory);
            System.out.println(checkout.finalizarPedido(pedido));
        }catch(PagamentoRecusadoException | IllegalArgumentException e){
            System.out.println("[" + pedido.getNumero() + "] " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args){
        // Brasil: venda interestadual (SP -> RJ) paga via Pix
        finalizar(
            new CheckoutBrasilFactory("SP", "PIX"),
            new Pedido("BR-1001", "Ana Souza", "Rua das Laranjeiras, 120 - Rio de Janeiro", "RJ", "22240003", List.of(
                new ItemPedido("Fone Bluetooth", 299.90, 1, false),
                new ItemPedido("Capa para celular", 49.90, 2, false)
            ))
        );

        // Brasil: venda dentro do estado (SP -> SP) paga via boleto
        finalizar(
            new CheckoutBrasilFactory("SP", "BOLETO"),
            new Pedido("BR-1002", "Bruno Lima", "Av. Paulista, 1000 - São Paulo", "SP", "01310-100", List.of(
                new ItemPedido("Cafeteira", 459.00, 1, false)
            ))
        );

        // Estados Unidos: entrega na California, cartão com AVS aprovado
        finalizar(
            new CheckoutEUAFactory("12-3456789", "4111111111111111", "94105", "94105"),
            new Pedido("US-2001", "John Smith", "500 Market St, San Francisco", "CA", "94105-1234", List.of(
                new ItemPedido("Havaianas", 25.00, 3, false),
                new ItemPedido("Brazilian coffee 1lb", 18.50, 2, false)
            ))
        );

        // Alemanha: itens essenciais (7%) e comuns (19%), débito SEPA
        finalizar(
            new CheckoutAlemanhaFactory("DE123456789", "DE89370400440532013000"),
            new Pedido("DE-3001", "Lukas Müller", "Friedrichstraße 43, Berlin", "BE", "10117", List.of(
                new ItemPedido("Café brasileiro 500g", 12.90, 2, true),
                new ItemPedido("Camisa da seleção", 89.90, 1, false)
            ))
        );

        // Estados Unidos: AVS recusado (ZIP de cobrança diferente do cadastro)
        finalizar(
            new CheckoutEUAFactory("12-3456789", "5500000000000004", "73301", "75001"),
            new Pedido("US-2002", "Mary Johnson", "100 Congress Ave, Austin", "TX", "78701-4042", List.of(
                new ItemPedido("Açaí powder", 30.00, 1, false)
            ))
        );
    }
}
