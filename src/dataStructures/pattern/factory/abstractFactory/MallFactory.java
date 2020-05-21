package dataStructures.pattern.factory.abstractFactory;

import dataStructures.pattern.factory.Car;
import dataStructures.pattern.factory.TV;

public interface MallFactory {
    Car initCar();
    TV initTV();
}
