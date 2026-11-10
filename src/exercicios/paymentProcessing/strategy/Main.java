package paymentProcessing.strategy;

public class Main {
    public static void main(String[] args){
        String paymentMethod = "TED";
        Double paymentAmount = 250.00;

        PaymentProcessor processor = new PaymentProcessor(paymentMethod);

        try{
            switch(paymentMethod){
                case "CREDIT CARD":
                    System.out.println("User chose to pay by Credit Card.");
                    
                    String cardNumber = "1233098213254234";
                    int yearExpDate = 2026;

                    PaymentStrategy creditCard = new CreditCard(cardNumber, yearExpDate);
                    creditCard.showInfo();
                    creditCard.charge(paymentAmount);
                    break;
                case "PAYPAL":
                    System.out.println("User chose to pay by PayPal.");

                    String email = "ryann@email.com";

                    PaymentStrategy payPal = new PayPal(email);
                    payPal.charge(paymentAmount);
                    payPal.showInfo();
                    break;
                case "TED":
                    System.out.println("User chose to pay by TED.");

                    String banco = "Bradesco";
                    int agencia = 13;
                    int conta = 1234;
                    
                    PaymentStrategy ted = new TED(banco, agencia, conta);
                    ted.showInfo();
                    ted.charge(paymentAmount);
                    break;
                default:
                    throw new IllegalArgumentException("payment method is not supported!");
            }
        } catch(IllegalArgumentException e){
            System.err.println("The '" + userPaymentMethod + "' " + e.getMessage());
        }
    }
}
