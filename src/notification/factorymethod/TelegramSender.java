package notification.factorymethod;

public class TelegramSender implements Sender{
    public void send(String msg){
        System.out.println("Enviando a mensagem: '" + msg + "', via Telegram!");
    }
}
