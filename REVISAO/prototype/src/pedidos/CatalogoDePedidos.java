package pedidos;

import java.util.Map;
import java.util.HashMap;

public class CatalogoDePedidos {
    private final Map<String, Pedido> modelos = new HashMap<>();

    public void registrar(String chave, Pedido modelo){
        modelos.put(chave, modelo);
    }

    public Pedido criar(String chave){
        Pedido modelo = modelos.get(chave);

        if(modelo == null){
            throw new IllegalArgumentException("Chave não registrada: " + chave);
        }

        return modelo.clonar();
    }
}
