package notification.normal;

public class Main {
    public static void main(String[] args){
        Notifier n = new Notifier();
        n.alert("EMAIL", "Mensagem digitada via E-mail!");
        n.alert("SMS", "Mensagem digitada via SMS!");
        n.alert("PUSH", "Mensagem digitada via Push!");
        n.alert("TESTE", "Mensagem digitada via Teste!");
    }
}
