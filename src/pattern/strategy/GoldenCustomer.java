package pattern.strategy;

public class GoldenCustomer implements Customer {
    @Override
    public double getDiscount() {
        double discount = 0.80;
        System.out.println("here is GoldenCustomer, discount is "+discount);
        return discount;
    }
}
