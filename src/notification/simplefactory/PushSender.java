package notification.simplefactory;

public class PushSender implements Sender{
    public void send(String msg){
        System.out.println("Enviando uma mensagem do tipo Push!");
    }
}
