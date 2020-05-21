package dataStructures.pattern.strategy;

public class SliverCustomer implements Customer {
    @Override
    public double getDiscount() {
        double discount = 0.95;
        System.out.println("here is SliverCustomer, discount is " + discount);
        return discount;
    }
}
