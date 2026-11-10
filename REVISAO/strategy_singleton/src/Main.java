import java.util.List;
import java.util.ArrayList;

public class Main { // CLIENT
    public static void main(String[] args){
        Order order = new Order();
        order.setId(1);
        order.setDistanceKm(100.00);
        order.setWeightKg(2.00);

        ShippingCalculator shippingCalculator = new ShippingCalculator();
        List<ShippingStrategy> shippingList = new ArrayList<>();
        shippingList.add(new PacShipping());
        shippingList.add(new SedexShipping());
        shippingList.add(new PickupShipping());

        // calculate without a strategy: throws and logs nothing
        try{
            shippingCalculator.calculate(order);
        } catch(IllegalStateException e){
            System.err.println(e.getMessage());
        }

        // (a) same calculator, switching strategies, default rates
        for (ShippingStrategy strategy : shippingList) {
            shippingCalculator.setStrategy(strategy);
            System.out.printf("%s: R$ %.2f\n", strategy.getName(), shippingCalculator.calculate(order));
        }

        // (b) change the PAC rate and calculate PAC again
        StoreConfig config = StoreConfig.getInstance();
        config.setPacRateByKg(5.00);
        shippingCalculator.setStrategy(shippingList.get(0));
        System.out.printf("PAC (new rate): R$ %.2f\n", shippingCalculator.calculate(order));

        // (c) restore default rates
        config.restoreDefaultAttributes();

        // (d) same object?
        System.out.println("Same instance: " + (StoreConfig.getInstance() == StoreConfig.getInstance()));

        // (e) audit log
        for (String line : AuditLog.getInstance().getRegistry()) {
            System.out.println(line);
        }
    }
}