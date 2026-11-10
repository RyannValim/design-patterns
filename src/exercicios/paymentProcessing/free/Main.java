package paymentProcessing.free;

public class Main {
    public static void main(String[] args){
        String userPaymentMethod = "TED";
        Double paymentAmount = 250.00;

        try{
            switch(userPaymentMethod){
                case "CREDIT CARD":
                    System.out.println("User chose to pay by Credit Card.");
                    
                    String cardNumber = "1233098213254234";
                    int yearExpDate = 2026;

                    CreditCard creditCard = new CreditCard(cardNumber, yearExpDate);
                    creditCard.showInfo();
                    creditCard.charge(paymentAmount);
                    break;
                case "PAYPAL":
                    System.out.println("User chose to pay by PayPal.");

                    String email = "ryann@email.com";

                    PayPal payPal = new PayPal(email);
                    payPal.charge(paymentAmount);
                    payPal.showInfo();
                    break;
                case "TED":
                    System.out.println("User chose to pay by TED.");

                    String banco = "Bradesco";
                    int agencia = 13;
                    int conta = 1234;
                    
                    TED ted = new TED(banco, agencia, conta);
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
