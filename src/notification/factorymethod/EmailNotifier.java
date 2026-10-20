package notification.factorymethod;

public class EmailNotifier extends Notifier{
    protected Sender createSender(){
        return new EmailSender();
    }
}
