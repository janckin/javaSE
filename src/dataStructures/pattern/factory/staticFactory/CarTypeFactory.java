package dataStructures.pattern.factory.staticFactory;

import dataStructures.pattern.factory.Car;

public class CarTypeFactory {
    public static Car getCarByName(String carType) {
        CarType carEnum = null;
        try {
            carEnum = CarType.valueOf(carType.toUpperCase());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (carEnum == null) {
            throw new IllegalArgumentException();
        }
        return carEnum.getCar();
    }
}
