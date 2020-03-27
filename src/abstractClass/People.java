package abstractClass;

public abstract class People {
    String name;
    private int i;

    public abstract void eat();

    public abstract void walk();

    public People() {

    }

    //凡是类都有构造器
    public People(String name) {
        this.name = name;
    }

    public People(int i) {
        this.i = i;
    }

    public int getI() {

        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}
