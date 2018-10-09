package section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
    }



}
