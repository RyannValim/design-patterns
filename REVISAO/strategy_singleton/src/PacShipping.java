public class PacShipping implements ShippingStrategy{
    private String name = "PAC";

    @Override
    public String getName(){ return this.name; }

    @Override
    public double calculate(Order order){
        StoreConfig instance = StoreConfig.getInstance();
        
        return (
            (order.getDistanceKm() * instance.getPacRateByKm()) +
            (order.getWeightKg() * instance.getPacRateByKg())
        );
    }
}
