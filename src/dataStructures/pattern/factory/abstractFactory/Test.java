package dataStructures.pattern.factory.abstractFactory;

import dataStructures.pattern.factory.Car;
import dataStructures.pattern.factory.TV;

public class Test {
    public static void main(String[] args) {
        MallFactory mallFactory = new Guangbai();
        Car car = mallFactory.initCar();
        car.build();
        TV tv = mallFactory.initTV();
        tv.repair();
    }
}
