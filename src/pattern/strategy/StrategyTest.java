package pattern.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        Customer goldenCustomer = CustomerManager.getCustomerByTypeName("GOLDEN");
        System.out.println(goldenCustomer.getDiscount());

        Customer silverCustomer = CustomerManager.getCustomerByTypeName("SILVER");
        System.out.println(silverCustomer.getDiscount());

        Customer commonCustomer = CustomerManager.getCustomerByTypeName("COMMON");
        System.out.println(commonCustomer.getDiscount());

        CustomerManager customerManager = new CustomerManager(new GoldenCustomer());
        customerManager.execute();

    }
}
