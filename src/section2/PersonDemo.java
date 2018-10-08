package section2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PersonDemo {
    public static void main(String[] args) {
        int count=0;
        while (count < 10000000) {
            Person p=new Person(new Date());
            p.isBabyBoomer2();
            count++;
            NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
                    .setCalories(100)
                    .setSodium(35)
                    .setCarbohydrate(27)
                    .build();
        }
    }
}
class Person{
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /*
     * 效率低下的方法
     * */
    public boolean isBabyBoomer() {
        Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart=gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd=gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 &&
                birthDate.compareTo(boomEnd) < 0;
    }
    /*
     *改进后的做法(快了250倍)
     * */
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    static {
        Calendar gmtCal=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START=gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END=gmtCal.getTime();
    }

    public boolean isBabyBoomer2() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }
}
