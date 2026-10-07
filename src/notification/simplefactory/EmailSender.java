package notification.simplefactory;

public class EmailSender implements Sender{
    public void send(String msg){
        System.out.println("Enviando notificação do tipo E-mail!");
    }
}
