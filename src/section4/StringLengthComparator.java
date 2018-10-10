package section4;

public class StringLengthComparator {
    private static StringLengthComparator ourInstance = new StringLengthComparator();

    public static StringLengthComparator getInstance() {
        return ourInstance;
    }

    private StringLengthComparator() {
    }

    public int compare(String s1, String s2) {
        return s1.length()-s2.length();
    }
}
