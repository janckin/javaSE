package dataStructures.pattern.factory.factoryMethod;

import dataStructures.pattern.factory.TV;

public class Test {
    public static void main(String[] args) {
        Factory sonyFactory = new SonyFactory();
        TV sony = sonyFactory.init();
        sony.repair();
    }
}
