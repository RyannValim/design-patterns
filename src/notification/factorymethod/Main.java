package notification.factorymethod;

public class Main {
    public static void main(String[] args){
        Notifier notifier = new EmailNotifier();
        String userPrompt = "WHATSAPP";

        try{
            switch(userPrompt){
                case "SMS":
                    notifier = new SmsNotifier();
                    break;
                case "PUSH":
                    notifier = new PushNotifier();
                    break;
                case "TELEGRAM":
                    notifier = new TelegramNotifier();
                    break;
                case "WHATSAPP":
                    notifier = new WhatsAppNotifier();
                    break;
                default:
                    throw new IllegalArgumentException("Este canal não foi implementado ainda!");
            }

            notifier.alert("Enviando uma mensagem!");
        } catch(IllegalArgumentException e){
            System.err.println("Erro: " + e.getMessage());
        }
    }
}