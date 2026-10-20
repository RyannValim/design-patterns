package notification.factorymethod;

public abstract class Notifier{
    protected abstract Sender createSender(); // método (FactoryMethod())

    public void alert(String msg){ // método (AnOperation())
        Sender sender = createSender();
        sender.send(msg);
    }
}
