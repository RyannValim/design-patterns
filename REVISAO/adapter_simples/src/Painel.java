import java.util.List;
import java.util.Locale;

public class Painel {                  // Client
    public void exibir(List<Target> ambientes) {
        for (Target a : ambientes) {
            System.out.printf(Locale.of("pt", "BR"),
                "%s | %.1f \u00b0C%n", a.nomeAmbiente(), a.temperaturaCelsius()
            );
        }
    }
}
