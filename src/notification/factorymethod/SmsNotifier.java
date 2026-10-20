package notification.factorymethod;

public class SmsNotifier extends Notifier{
    protected Sender createSender(){
        return new SmsSender();
    }
}
