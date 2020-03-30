package dateKnowledge;

public class LittleGame {

    public static void main(String[] args) {
        //9*9 multiply
        for (int i = 1; i < 10; i++) {

            StringBuffer sb = new StringBuffer();

            for (int j = 1; j < 10; j++) {
                if (i < j) {
                    break;
                }
                sb.append(i + " × " + j + " = " + (i * j) + " , ");
            }

            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

}
