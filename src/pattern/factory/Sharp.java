package pattern.factory;

public class Sharp implements TV {
    public Sharp(){
        System.out.println("build sharp TV");
    }

    @Override
    public void repair() {
        System.out.println("repair sharp TV");
    }
}
