package section7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            //这里i被自动装箱到Integer中。程序不会从集合中去除正值
            //列表去除的是从哪个位置开始
            //list.remove( i);
            list.remove((Integer)i);
        }
        System.out.println(set + " " + list);
    }
}
