package enumKnowledge;

public class TestGender {
    public static void main(String[] args) {
        //throws IllegalArgumentException
        /*Season season = Season.valueOf("hello");
        System.out.println(season.toString());*/
        System.out.println(Season.AUTUMN.toString());

        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            System.out.println(gender.name() + ":" + gender.getValue());
        }
    }
}
