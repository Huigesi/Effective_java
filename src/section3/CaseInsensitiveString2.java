package section3;

import java.util.Comparator;

public class CaseInsensitiveString2 implements Comparable<CaseInsensitiveString2> {
    private final String s;

    public CaseInsensitiveString2(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CaseInsensitiveString2) {
            return s.equalsIgnoreCase(((CaseInsensitiveString2) obj).s);
        }
        /*if (obj instanceof String) {
            return s.equalsIgnoreCase((String) obj);
        }*/
        return false;
    }

    @Override
    public int compareTo(CaseInsensitiveString2 o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s,o.s);
    }
}
