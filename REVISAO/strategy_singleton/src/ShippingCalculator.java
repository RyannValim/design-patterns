import java.util.Locale;

public class ShippingCalculator { // CONTEXT
    private ShippingStrategy strategy = null;

    public void setStrategy(ShippingStrategy strategy){ this.strategy = strategy; }

    public double calculate(Order order){
        // null check
        if(this.strategy == null){
            throw new IllegalStateException("Null strategy!");
        }

        int id = order.getId();
        String name = strategy.getName();
        double total = this.strategy.calculate(order);

        AuditLog auditLog = AuditLog.getInstance();
        auditLog.register(String.format(Locale.US, "pedido=%d estrategia=%s frete=%.2f", id, name, total));

        return total;
    }
}
