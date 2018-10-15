package section8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double funds=2.00;
        int itemsBought=0;
        for (double price = .10; funds >= price; price += .10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought");
        System.out.println("Change: $"+funds);
        //BigDecimal
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought2=0;
        BigDecimal funds2 = new BigDecimal("2.00");
        for (BigDecimal price = TEN_CENTS;
             funds2.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            itemsBought2++;
            funds2 = funds2.subtract(price);
        }
        System.out.println(itemsBought2+" items bought.");
        System.out.println("Money left over: $" + funds2);
        //int
        int itemsBought3=0;
        int funds3=200;
        for (int price = 10; funds3 >= price; price += 10) {
            itemsBought3++;
            funds3 -= price;
        }
        System.out.println(itemsBought3 + " item bought.");
        System.out.println("Money left over: "+funds3+" cents");
    }
}
