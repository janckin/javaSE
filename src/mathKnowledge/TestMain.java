package mathKnowledge;

import java.math.BigDecimal;

public class TestMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //BigDecimal();
        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        //0.01 will cause the lose
        System.out.println("old:>>" + (0.05 + 0.01));
        System.out.println("new : >>" + (f1.add(f2)));

    }

}
