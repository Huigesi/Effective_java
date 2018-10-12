package section7;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }
/*
    public static String classify(Collection<?> collection) {
        return "Unknown Collection";
    }*/

    public static String classify(Collection<?> collection) {
        return collection instanceof Set ? "Set" :
                collection instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
