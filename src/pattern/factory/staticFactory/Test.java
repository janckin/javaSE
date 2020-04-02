package pattern.factory.staticFactory;

import pattern.factory.Car;

public class Test {
    public static void main(String[] args) {
        Car toyota = CarFactory.getCarByName("toyota");
        Car bmw = CarFactory.getCarByName("bmw");
        Car audi = CarFactory.getCarByName("audi");

        System.out.println("------------------------------");
        Car toyota2 = CarTypeFactory.getCarByName("toyota");
        Car bmw2 = CarTypeFactory.getCarByName("bmw");
        Car audi2 = CarTypeFactory.getCarByName("audi");
    }
}
