package paymentProcessing.strategy;

import java.util.List;
import java.util.ArrayList;

public class CreditCard implements PaymentStrategy{
    private String number;
    private int yearExpDate;
    private List<Double> statement;
    
    public CreditCard(
        String number,
        int yearExpDate
    ){
        this.number = number;
        this.yearExpDate = yearExpDate;
        this.statement = new ArrayList<>();
    }

    public String getNumber(){ return this.number; }
    public int getYearExpDate(){ return this.yearExpDate; }

    public Double calcTax(Double amount){
        return amount * 0.025;
    }

    public void charge(Double amount){
        if(getYearExpDate() < 2026 || getNumber().length() != 16){
            if(getYearExpDate() < 2026){
                System.out.println("Your credit card is expired!");
            }

            if(getNumber().length() != 16){
                System.out.println("Your credit card number is invalid!");
            }
            return;
        }

        Double totalTax = calcTax(amount);
        Double totalAmount = amount + totalTax;
        this.statement.add(totalAmount);
        System.out.printf("R$%.2f was charged in your Credit Card!\n", totalAmount);
        System.out.printf(" > tax: R$%.2f\n", totalTax);
    }

    public Double calcCurrStatement(){
        Double currTotal = 0.00;
        for (Double item : statement) {
            currTotal += item;
        }
    
        return currTotal;
    }

    public void showInfo(){
        System.out.println("\n===== Credit card info: =====");
        System.out.println("Card Number: " + getNumber() + ".");
        System.out.println("Expiration Date: " + getYearExpDate() + ".");
        System.out.println("Current Total Statement: " + calcCurrStatement());
        System.out.println("===============================\n");
    }
}
