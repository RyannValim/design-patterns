public class PickupShipping implements ShippingStrategy{
    private String name = "PICKUP";

    @Override
    public String getName(){ return this.name; }

    @Override
    public double calculate(Order order){ return 0.00; }
}
