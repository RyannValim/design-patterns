package pedido.observer;

public class Auditoria implements Observer{
    private String statusObserver;
    private Pedido p;

    // caso tenha mais de um Subject, é a interface quem vai diferenciá-los
    public void update(Subject s){
        
    }
}
