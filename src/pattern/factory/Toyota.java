package pattern.factory;

public class Toyota implements Car {
    public Toyota(){
        System.out.println("build a toyota car");
    }
    @Override
    public void build() {
        System.out.println("toyota build method");
    }
}
