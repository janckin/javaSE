package enumKnowledge.enumeration;

public class TestEnum {

    public static void main(String[] args) {
        String provinceId = UserStandard.PROVINCE.getId();
        System.out.println(provinceId);
        //自定义的枚举类市没有遍历的！！！
        SecurityLevel province = SecurityLevel.PROVINCE;
    }

}
