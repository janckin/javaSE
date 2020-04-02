package pattern.factory.staticFactory;

import pattern.factory.Audi;
import pattern.factory.BMW;
import pattern.factory.Car;
import pattern.factory.Toyota;

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
