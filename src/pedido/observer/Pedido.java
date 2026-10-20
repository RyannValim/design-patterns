package pedido.observer;

import java.util.List;
import java.util.ArrayList;

public class Pedido implements Subject{
    private String statusPedido;
    private List<Observer> observadores = new ArrayList<>();

    public void setStatusPedido(String status){ this.statusPedido = status; }
    public String getStatusPedido(){ return this.statusPedido; }

    public void notificar(){
        for(Observer o : observadores){
            o.update();
        }
    }

    public void inscrever(Observer o){
        observadores.add(o);
        // System.out.println("Observer '" + o + "' inscreveu-se em Pedido!");
    }

    public void desinscrever(Observer o){
        observadores.remove(o);
        // System.out.println("Observer '" + o + "' desinscreveu-se de Pedido!");
    }
}
