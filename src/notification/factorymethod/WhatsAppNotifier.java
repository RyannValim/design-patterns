package notification.factorymethod;

public class WhatsAppNotifier extends Notifier{
    protected Sender createSender(){
        return new WhatsAppSender();
    }
}