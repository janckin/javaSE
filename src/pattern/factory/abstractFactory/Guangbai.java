package pattern.factory.abstractFactory;

import pattern.factory.Audi;
import pattern.factory.Car;
import pattern.factory.Sharp;
import pattern.factory.TV;

public class Guangbai implements MallFactory {
    public Guangbai() {
        System.out.println("build Guangbai");
    }

    @Override
    public Car initCar() {
        return new Audi();
    }

    @Override
    public TV initTV() {
        return new Sharp();
    }
}
