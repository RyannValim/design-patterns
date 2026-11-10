public class StoreConfig {
    // valores padrão: nunca mudam
    private static final double DEFAULT_PAC_RATE_BY_KG = 2.5;
    private static final double DEFAULT_PAC_RATE_BY_KM = 0.05;
    private static final double DEFAULT_SEDEX_RATE_BY_KG = 4.00;
    private static final double DEFAULT_SEDEX_RATE_BY_KM = 0.12;
    private static final double DEFAULT_SEDEX_URGENCY_RATE = 15.00;

    // valores atuais: começam iguais aos padrão e mudam pelos setters
    private double pacRateByKg = DEFAULT_PAC_RATE_BY_KG;
    private double pacRateByKm = DEFAULT_PAC_RATE_BY_KM;
    private double sedexRateByKg = DEFAULT_SEDEX_RATE_BY_KG;
    private double sedexRateByKm = DEFAULT_SEDEX_RATE_BY_KM;
    private double sedexUrgencyRate = DEFAULT_SEDEX_URGENCY_RATE;

    private StoreConfig(){}

    // Holder: caixa que guarda o objeto único.
    // A JVM só carrega esta classe na primeira chamada ao getInstance
    // e garante que isso acontece uma única vez, mesmo com várias threads.
    private static class Holder {
        private static final StoreConfig INSTANCE = new StoreConfig();
    }

    // sem if: quem verifica e cria é a JVM, com segurança
    public static StoreConfig getInstance(){
        return Holder.INSTANCE;
    }

    // o atributo atual recebe o padrão
    public void restoreDefaultAttributes(){
        this.pacRateByKg = DEFAULT_PAC_RATE_BY_KG;
        this.pacRateByKm = DEFAULT_PAC_RATE_BY_KM;
        this.sedexRateByKg = DEFAULT_SEDEX_RATE_BY_KG;
        this.sedexRateByKm = DEFAULT_SEDEX_RATE_BY_KM;
        this.sedexUrgencyRate = DEFAULT_SEDEX_URGENCY_RATE;
    }

    public double getPacRateByKg() { return this.pacRateByKg; }
    public void setPacRateByKg(double value) { this.pacRateByKg = value; }

    public double getPacRateByKm() { return this.pacRateByKm; }
    public void setPacRateByKm(double value) { this.pacRateByKm = value; }

    public double getSedexRateByKg() { return this.sedexRateByKg; }
    public void setSedexRateByKg(double value) { this.sedexRateByKg = value; }

    public double getSedexRateByKm() { return this.sedexRateByKm; }
    public void setSedexRateByKm(double value) { this.sedexRateByKm = value; }

    public double getSedexUrgencyRate() { return this.sedexUrgencyRate; }
    public void setSedexUrgencyRate(double value) { this.sedexUrgencyRate = value; }
}