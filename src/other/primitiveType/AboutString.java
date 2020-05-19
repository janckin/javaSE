package other.primitiveType;

public class AboutString {
    public static void main(String[] args) {
        testSubString();
        testJoin();
    }

    public static void testSubString() {
        /* "hamburger".substring(4, 8) returns "urge"
         * "smiles".substring(1, 5) returns "mile"
         **/
        String s = "hamburger";
        System.out.println(s.substring(4, 8));
    }

    public static void testJoin(){
        String s = String.join("","hello","World","Autumn");
        System.out.println(s);

        String s2 = String.join(",","tom","jerry","penny","shelden");
        System.out.println(s2);
    }
}
