package pattern.strategy;

public class CommonCustomer implements Customer {
    @Override
    public double getDiscount() {
        double discount = 0.00;
        System.out.println("here is common,discount is "+discount);
        return discount;
    }
}
