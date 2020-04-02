package pattern.factory.staticFactory;

import pattern.factory.Car;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class CarNameReader {
    private static Map<String, String> cars;

    public synchronized static Map<String, String> init() {
        if (cars == null) {
            cars = createMap();
        }
        return cars;
    }

    private static Map<String, String> createMap() {
        cars = new HashMap<>();
        InputStream in = Car.class.getResourceAsStream("SimpleFactory.properties");
        try {
            Properties pro = new Properties();
            pro.load(in);
            for (String key : pro.stringPropertyNames()) {
                String value = pro.getProperty(key);
                cars.put(key, value);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
