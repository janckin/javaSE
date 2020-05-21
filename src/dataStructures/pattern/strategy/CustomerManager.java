package dataStructures.pattern.strategy;

public class CustomerManager {
    private Customer customer;
    public CustomerManager(Customer customer){
        this.customer = customer;
    }
    public static Customer getCustomerByTypeName(String type){
        CustomerType customerType = CustomerType.valueOf(type);
        return customerType.getCustomer();
    }
    //provide method for users to call
    public double execute(){
        System.out.println("before discount do something or combine other method");
        return customer.getDiscount();
    }
}
