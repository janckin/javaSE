package pattern.factory.factoryMethod;

import pattern.factory.Sony;
import pattern.factory.TV;

public class SonyFactory implements Factory {
    @Override
    public TV init() {
        return new Sony();
    }
}
