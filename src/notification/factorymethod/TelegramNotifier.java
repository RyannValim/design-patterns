package notification.factorymethod;

public class TelegramNotifier extends Notifier{
    protected Sender createSender(){
        return new TelegramSender();
    }
}
