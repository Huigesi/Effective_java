package section2;

public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    String s = "stringette";

    public static void main(String[] args) {
        Long sum=0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
