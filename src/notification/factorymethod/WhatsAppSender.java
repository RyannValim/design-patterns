package notification.factorymethod;

public class WhatsAppSender implements Sender{
    @Override
    public void send(String msg){
        System.out.println("Enviando a mensagem: '" + msg + "', via WHATSAPP!");
    }
}
