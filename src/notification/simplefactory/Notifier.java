package notification.simplefactory;

public class Notifier{
    private SenderFactory senderFactory;
    
    public Notifier(SenderFactory senderFactory){
        this.senderFactory = senderFactory;
    }

    public void alert(String channel, String msg){
        Sender sender;

        try{
            sender = this.senderFactory.createSender(channel);
        } catch(IllegalArgumentException e){
            System.err.println("Erro: " + e.getMessage());
            return;
        }

        sender.send(msg);
    }
}
