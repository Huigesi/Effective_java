package section5;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Warnings {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet();
        stringSet.clear();
        System.out.println(stringSet);
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE));
    }
}
