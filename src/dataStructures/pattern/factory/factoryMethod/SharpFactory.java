package dataStructures.pattern.factory.factoryMethod;

import dataStructures.pattern.factory.Sharp;
import dataStructures.pattern.factory.TV;

public class SharpFactory implements Factory {
    @Override
    public TV init() {
        return new Sharp();
    }
}
