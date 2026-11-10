package paymentProcessing.strategy;

public class TED implements PaymentStrategy{
    private String banco;
    private int agencia;
    private int conta;

    public TED(
        String banco,
        int agencia,
        int conta
    ){
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getBanco(){ return this.banco; }
    public int getAgencia(){ return this.agencia; }
    public int getConta(){ return this.conta; }

    public Double calcTax(Double amount){
        return 8.00;
    }

    public void charge(Double amount){
        if(amount > 5000.00){
            System.out.println("This amount surpass the daily limit!");
            return;
        }

        // i'm not doing a payment system here, too much for this lesson.
        Double totalTax = calcTax(amount);
        Double totalAmount = amount + totalTax;
        System.out.printf("R$%.2f was transfered by TED from your bank account!\n", totalAmount);
        System.out.printf(" > tax: R$%.2f\n", totalTax);
    }

    public void showInfo(){
        System.out.println("\n===== TED info: =====");
        System.out.println("Bank Name: " + getBanco() + ".");
        System.out.println("Agency: " + getAgencia() + ".");
        System.out.println("Account: " + getConta() + ".");
        System.out.println("=======================\n");
    }
}