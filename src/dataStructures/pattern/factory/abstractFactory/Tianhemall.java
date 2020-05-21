package dataStructures.pattern.factory.abstractFactory;

import dataStructures.pattern.factory.BMW;
import dataStructures.pattern.factory.Car;
import dataStructures.pattern.factory.Sony;
import dataStructures.pattern.factory.TV;

public class Tianhemall implements MallFactory {
    public Tianhemall() {
        System.out.println("build tianhemall");
    }

    @Override
    public Car initCar() {
        return new BMW();
    }

    @Override
    public TV initTV() {
        return new Sony();
    }
}
