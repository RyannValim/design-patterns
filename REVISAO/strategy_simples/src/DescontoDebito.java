public class DescontoDebito implements Desconto{
    @Override
    public double aplicar(double valor){ return valor * 0.95; }

    @Override
    public String nome() { return "Debito"; }
}
