package checkout;

import java.util.List;

// contrato comum aos três artefatos, usado pelo relatório padronizado (RNF03)
public interface ArtefatoCheckout{
    String getTipo();
    List<String> getDetalhes();
}
