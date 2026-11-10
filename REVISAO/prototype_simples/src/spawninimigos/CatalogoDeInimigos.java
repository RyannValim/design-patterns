package spawninimigos;

import java.util.Map;
import java.util.HashMap;

public class CatalogoDeInimigos {
    private final Map<String, Inimigo> modelosInimigo = new HashMap<>();

    public void registrar(String chave, Inimigo prototipo){
        modelosInimigo.put(chave, prototipo);
    }

    public Inimigo criar(String chave){
        Inimigo modeloInimigo = modelosInimigo.get(chave);

        if(modeloInimigo == null){
            throw new IllegalArgumentException("Inimigo '" + chave + "' não encontrado!");
        }

        return modeloInimigo.clonar();
    }
}
