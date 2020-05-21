package dataStructures.pattern.factory.factoryMethod;

import dataStructures.pattern.factory.Sony;
import dataStructures.pattern.factory.TV;

public class SonyFactory implements Factory {
    @Override
    public TV init() {
        return new Sony();
    }
}
