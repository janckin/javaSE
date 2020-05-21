package dataStructures.pattern.factory.staticFactory;

import dataStructures.pattern.factory.Audi;
import dataStructures.pattern.factory.BMW;
import dataStructures.pattern.factory.Car;
import dataStructures.pattern.factory.Toyota;

public enum CarType {
    AUDI(new Audi()),
    BMW(new BMW()),
    TOYOTA(new Toyota());
    private Car car;

    CarType(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
