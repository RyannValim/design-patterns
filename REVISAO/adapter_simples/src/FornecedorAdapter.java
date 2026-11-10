import java.util.Map;

public class FornecedorAdapter implements Target {   // Adapter

    private static final Map<Integer, String> NOMES = Map.of(
        101, "Camara Fria",
        102, "Estoque Seco",
        103, "Doca de Carga"
    );

    private final Fornecedor fornecedor;

    public FornecedorAdapter(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public double temperaturaCelsius() {
        double fahrenheit = fornecedor.getTempFahrenheit() / 10.0;
        return (fahrenheit - 32) * 5 / 9.0;
    }

    @Override
    public String nomeAmbiente() {
        String nome = NOMES.get(fornecedor.getCodAmbiente());
        if (nome == null) {
            return "Ambiente " + fornecedor.getCodAmbiente();
        }
        return nome;
    }
}
