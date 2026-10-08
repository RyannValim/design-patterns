package notification.simplefactory;

public class EmailSender implements Sender{
    @Override
    public void send(String msg){
        System.out.println("Enviando a mensagem: '" + msg + "', via E-MAIL!");
    }
}
