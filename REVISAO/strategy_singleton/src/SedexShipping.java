public class SedexShipping implements ShippingStrategy{
    private String name = "SEDEX";
    
    @Override
    public String getName(){ return this.name; }

    @Override
    public double calculate(Order order){
        StoreConfig instance = StoreConfig.getInstance();

        return (
            (order.getDistanceKm() * instance.getSedexRateByKm()) +
            (order.getWeightKg() * instance.getSedexRateByKg()) +
            instance.getSedexUrgencyRate()
        );
    }
}
