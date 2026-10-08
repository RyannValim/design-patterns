package notification.simplefactory;

public class SenderFactory{
    public Sender createSender(String channel){
        if("EMAIL".equals(channel)){
            return new EmailSender();
        } else if("SMS".equals(channel)){
            return new SmsSender();
        } else if("PUSH".equals(channel)){
            return new PushSender();
        } else{
            throw new IllegalArgumentException("O canal '" + channel + "' não existe!");
        }
    }
}
