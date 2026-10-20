package pedido.observer;

public class PainelCozinha implements Observer{
    private String statusObserver;

    public void update(String status){
        this.statusObserver = status;
        if(this.statusObserver.equals("Preparando")){
            System.out.println("PAINELCOZINHA: Preparando pedido n° X.");
        }
    }
}
