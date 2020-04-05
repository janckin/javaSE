package generic.reflectClass;

public class TestEnumContants {
    public static void main(String[] args) {
        Class<Season> clazz = Season.class;
        Season[] seasons = clazz.getEnumConstants();
        for (Season s : seasons) {
            System.out.println(s.name);
        }
    }
}
