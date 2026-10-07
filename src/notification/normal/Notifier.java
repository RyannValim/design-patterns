package notification.normal;

public class Notifier{
    public void alert(String channel, String msg){
        if(channel.equals("EMAIL")){
            Sender s = new EmailSender();
            s.send(msg);
        } else if(channel.equals("SMS")){
            Sender s = new SmsSender();
            s.send(msg);
        } else if(channel.equals("PUSH")){
            Sender s = new PushSender();
            s.send(msg);
        } else{
            System.err.println("O tipo de canal mencionado não existe!");
        }
    }
}
