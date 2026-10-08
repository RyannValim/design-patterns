package notification.simplefactory;

public class Main {
    public static void main(String[] args){
        SenderFactory sF = new SenderFactory();
        Notifier n = new Notifier(sF);
        n.alert("EMAIL", "Mensagem digitada via E-mail!");
        n.alert("SMS", "Mensagem digitada via SMS!");
        n.alert("PUSH", "Mensagem digitada via Push!");
        n.alert("TESTE", "Mensagem digitada via Teste!");
        n.alert(null, "Teste: mensagem NULL!");
        n.alert("EMAIL", null);
    }
}
