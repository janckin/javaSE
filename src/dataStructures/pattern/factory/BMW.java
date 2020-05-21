package dataStructures.pattern.factory;

public class BMW implements Car {
    public BMW() {
        System.out.println("build bmw car");
    }

    @Override
    public void build() {
        System.out.println("bmw build method");
    }
}
