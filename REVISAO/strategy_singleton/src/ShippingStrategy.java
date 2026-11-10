public interface ShippingStrategy {
    double calculate(Order order);
    String getName();
}
