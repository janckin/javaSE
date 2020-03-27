package enumKnowledge.enumeration;

public class UserStandard extends OldEnumModel {
    public static final UserStandard PROVINCE = new UserStandard("39992", "省级用户");
    public static final UserStandard CITY = new UserStandard("39992", "市级用户");
    public static final UserStandard DISTRICK = new UserStandard("39992", "区县级用户");

    private UserStandard(String id, String name) {
        super(id, name);
    }
}
