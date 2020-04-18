package enumKnowledge;

public class TestGender {
    public static void main(String[] args) {
        Gender[] genders = Gender.values();
        for (Gender gender : genders) {
            System.out.println(gender.name() + ":" + gender.getValue());
        }
    }
}
