import section3.CaseInsensitiveString;

public class Main {

    public static void main(String[] args) {
        CaseInsensitiveString cis=new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
}
