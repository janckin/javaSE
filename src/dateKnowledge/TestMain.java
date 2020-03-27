package dateKnowledge;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.TimeZone;

public class TestMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar cal = Calendar.getInstance();
        TimeZone zone = TimeZone.getTimeZone("GMT+8:00");
        Calendar cal_zone = Calendar.getInstance(zone);
        //System.out.println(cal.getTime());
        //System.out.println(cal_zone.getTime());

        //calendar method
        //month start with 0,so 2 equal March
        cal.set(2013, 2, 3, 23, 32, 22);
        //System.out.println(">>>>> set method:>"+cal.getTime());
        //Sunday equal 7
        //System.out.println(">>>>> get day method:>"+cal.DAY_OF_WEEK);

        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        System.out.println(clock.getZone());


        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        //System.out.println(df.format(cal.getTime()));
        //System.out.println(df.format(cal_zone.getTime()));

    }

}
