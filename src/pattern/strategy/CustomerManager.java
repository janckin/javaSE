package pattern.strategy;

public class CustomerManager {
    public static Customer getCustomerByTypeName(String type){
        CustomerType customerType = CustomerType.valueOf(type);
        return customerType.getCustomer();
    }
}
