package notification.factorymethod;

public class PushNotifier extends Notifier{
    protected Sender createSender(){
        return new PushSender();
    }
}
