package pedido.observer;

public interface Subject{
    public void notificar();
    public void inscrever(Observer o);
    public void desinscrever(Observer o);
}
