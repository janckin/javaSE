package pattern.factory.staticFactory;

import pattern.factory.Car;

public class Test {
    public static void main(String[] args) {
        Car toyota = CarFactory.getCarByName("toyota");
        Car bmw = CarFactory.getCarByName("bmw");
        Car audi = CarFactory.getCarByName("audi");
    }
}
