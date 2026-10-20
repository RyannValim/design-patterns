package notification.factorymethod;

public class SmsSender implements Sender{
    @Override
    public void send(String msg){
        System.out.println("Enviando a mensagem: '" + msg + "', via SMS!");
    }
}
