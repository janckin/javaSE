package pattern.factory.abstractFactory;

import pattern.factory.Car;
import pattern.factory.TV;

public class Test {
    public static void main(String[] args) {
        MallFactory mallFactory = new Guangbai();
        Car car = mallFactory.initCar();
        car.build();
        TV tv = mallFactory.initTV();
        tv.repair();
    }
}
