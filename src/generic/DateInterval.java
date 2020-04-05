package generic;

import java.time.LocalDate;

public class DateInterval extends Pair<LocalDate> {
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }
    public void testExtend(Object o){
        System.out.println("here in parent, param in "+ o);
    }
}
