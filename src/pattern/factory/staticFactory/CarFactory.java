package pattern.factory.staticFactory;

import pattern.factory.Car;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

public class CarFactory {
    private final static Map<String, String> propertyMap = CarNameReader.init();

    public static Car getCarByName(String carName) {
        Car car = null;
        try {
            for (Map.Entry<String, String> entry : propertyMap.entrySet()) {
                if (entry.getKey().equals(carName)) {
                    car = (Car) Class.forName(entry.getValue()).getDeclaredConstructor().newInstance();
                    break;
                }
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if (car == null) {
            throw new IllegalArgumentException("carname is illegal");
        }
        return car;

    }
}
