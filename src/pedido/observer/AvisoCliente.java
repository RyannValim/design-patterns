package pedido.observer;

public class AvisoCliente implements Observer{
    private String statusObserver;
    
    // caso tenha mais de um Subject, é a interface quem vai diferenciá-los
    public void update(String status){
        this.statusObserver = status;
        if(this.statusObserver.equals("Pedido pronto")){
            System.out.println("AVISOCLIENTE: Pedido n° X está pronto!");
        }
    }
}
