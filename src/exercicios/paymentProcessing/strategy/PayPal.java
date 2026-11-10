package paymentProcessing.strategy;

public class PayPal implements PaymentStrategy{
    private String email;

    public PayPal(
        String email
    ){
        this.email = email;
    }

    public String getEmail(){ return this.email; }

    public Double calcTax(Double amount){
        return 3.00 + amount * 0.01;
    }

    public void charge(Double amount){
        if(!getEmail().contains("@")){
            System.out.println("Invalid e-mail format!");
            return;
        }

        // i'm not doing a payment system here too...
        Double totalTax = calcTax(amount);
        Double totalAmount = amount + totalTax;
        System.out.printf("R$%.2f was charged from your PayPal account!\n", totalAmount);
        System.out.printf(" > tax: R$%.2f\n", totalTax);
    }

    public void showInfo(){
        System.out.println("\n===== TED info: =====");
        System.out.println("E-mail: " + getEmail() + ".");
        System.out.println("=======================\n");
    }
}
