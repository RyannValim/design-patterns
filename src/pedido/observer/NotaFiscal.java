package pedido.observer;

public class NotaFiscal implements Observer{
    private String statusObserver;
    
    // caso tenha mais de um Subject, é a interface quem vai diferenciá-los
    public void update(String status){
        this.statusObserver = status;
        if(this.statusObserver.equals("Pedido pronto")){
            System.out.println("NOTAFISCAL: Pedido n° X ---- R$ 35,00");
        }
    }
}
