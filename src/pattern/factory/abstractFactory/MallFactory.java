package pattern.factory.abstractFactory;

import pattern.factory.Car;
import pattern.factory.TV;

public interface MallFactory {
    Car initCar();
    TV initTV();
}
