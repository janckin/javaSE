package pattern.factory;

public class Audi implements Car {
    public Audi() {
        System.out.println("build audi car");
    }

    @Override
    public void build() {
        System.out.println("audi build method");
    }
}
