package dataStructures.pattern.factory.abstractFactory;

import dataStructures.pattern.factory.Audi;
import dataStructures.pattern.factory.Car;
import dataStructures.pattern.factory.Sharp;
import dataStructures.pattern.factory.TV;

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
