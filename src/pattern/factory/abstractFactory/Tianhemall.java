package pattern.factory.abstractFactory;

import pattern.factory.BMW;
import pattern.factory.Car;
import pattern.factory.Sony;
import pattern.factory.TV;

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
