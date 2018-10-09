package section3;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CaseInsensitiveString cis=new CaseInsensitiveString("Polish");
        String s = "polish";
        //System.out.println(cis.equals(s));
        //System.out.println(s.equals(cis));
        List<CaseInsensitiveString> list =
                new ArrayList<>();
        list.add(cis);
        //System.out.println(list.contains(s));
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        //System.out.println(p.equals(cp));
        //System.out.println(cp.equals(p));
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);/*
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));*/
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "jenny");
        System.out.println(m.get(new PhoneNumber(707,867,5309)));
    }
}
