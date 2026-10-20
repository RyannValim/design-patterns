package pedido.observer;

public class EnvioEntregador implements Observer{
    private String statusObserver;

    // caso tenha mais de um Subject, é a interface quem vai diferenciá-los
    public void update(String status){
        this.statusObserver = status;
        if(this.statusObserver.equals("Preparando")){
            System.out.println("ENVIOENTREGADOR: O pedido está sendo preparado!");
        }else if(this.statusObserver.equals("Pedido pronto")){
            System.out.println("ENVIOENTREGADOR: O pedido está pronto para retirada!");
        }
    }
}
