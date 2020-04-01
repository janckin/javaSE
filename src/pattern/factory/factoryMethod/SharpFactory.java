package pattern.factory.factoryMethod;

import pattern.factory.Sharp;
import pattern.factory.TV;

public class SharpFactory implements Factory {
    @Override
    public TV init() {
        return new Sharp();
    }
}
