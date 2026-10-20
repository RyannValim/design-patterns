package pedido.observer;

import java.util.List;
import java.util.ArrayList;

public class Pedido implements Subject{
    private String statusPedido;
    private List<Observer> observadores = new ArrayList<>();

    public void setStatusPedido(String status){
        this.statusPedido = status;
        this.notificar();
    }
    public String getStatusPedido(){ return this.statusPedido; }

    public void notificar(){
        for(Observer o : observadores){
            o.update(this.getStatusPedido());
        }
    }

    public void inscrever(Observer o){
        observadores.add(o);
    }

    public void desinscrever(Observer o){
        observadores.remove(o);
    }
}
