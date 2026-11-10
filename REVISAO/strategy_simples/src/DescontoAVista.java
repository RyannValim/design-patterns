public class DescontoAVista implements Desconto{
    @Override
    public double aplicar(double valor){ return valor * 0.9; }

    @Override
    public String nome() { return "A vista"; }
}
