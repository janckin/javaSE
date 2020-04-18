package enumKnowledge;

import java.lang.reflect.Field;

public class ClassicalEnum {
    public static class Season {
        public static final int SPRING = 0;
        public static final int SUMMER = 1;
        public static final int AUTUMN = 2;
        public static final int WINTER = 3;
    }

    public static class Gender {
        public static final int MALE = 0;
        public static final int FEMALE = 1;
    }

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("the value of spring:" + Season.SPRING);
        System.out.println("the value of Gender:" + Gender.FEMALE);

        System.out.println("loop for a group");
        Field[] fields = ClassicalEnum.Season.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("the value of Season:" + field.getName() + ",value:"+field.getInt(field));
        }
    }
}
