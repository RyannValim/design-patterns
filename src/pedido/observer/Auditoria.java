package pedido.observer;

public class Auditoria implements Observer{
    private String statusObserver;

    // caso tenha mais de um Subject, é a interface quem vai diferenciá-los
    public void update(String status){
        this.statusObserver = status;
        System.out.println("AUDITORIA: [LOG] - status alterado para '" + this.statusObserver + "'.");
    }
}
