package dataStructures.pattern.factory;

public class Sony implements TV {
    public Sony(){
        System.out.println("build sony TV");
    }
    @Override
    public void repair() {
        System.out.println("repair sony TV");
    }
}
