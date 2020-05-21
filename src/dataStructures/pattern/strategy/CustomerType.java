package dataStructures.pattern.strategy;

public enum CustomerType {
    COMMON("commonCustomer",new CommonCustomer(),"return the common customer"),
    GOLDEN("goldenCustomer",new GoldenCustomer(),"return the goldenCustomer"),
    SILVER("silverCustomer",new SliverCustomer(),"return the silverCustomer");

    private String type;
    private Customer customer;
    private String desc;

    CustomerType(String type, Customer customer, String desc) {
        this.type = type;
        this.customer = customer;
        this.desc = desc;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
