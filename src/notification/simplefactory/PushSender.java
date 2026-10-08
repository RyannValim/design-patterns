package notification.simplefactory;

public class PushSender implements Sender{
    @Override
    public void send(String msg){
        System.out.println("Enviando a mensagem: '" + msg + "', via PUSH!");
    }
}
