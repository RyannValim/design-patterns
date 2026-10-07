package notification.normal;

public class SmsSender implements Sender{
    public void send(String msg){
        System.out.println("Enviando notificação do tipo SMS!");
    }
}
