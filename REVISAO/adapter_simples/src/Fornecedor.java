public class Fornecedor {              // Adaptee - congelado
    private final int codAmbiente;
    private final int tempFahrenheit;  // decimos de grau F: 752 = 75,2 F

    public Fornecedor(int codAmbiente, int tempFahrenheit) {
        this.codAmbiente = codAmbiente;
        this.tempFahrenheit = tempFahrenheit;
    }

    public int getCodAmbiente() { return this.codAmbiente; }
    public int getTempFahrenheit() { return this.tempFahrenheit; }
}
