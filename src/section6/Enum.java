package section6;

public class Enum {
    public static final int APPLE_FUJI=0;
    public static final int APPLE_PIPPIN=1;
    public static final int APPLE_GRANNY_SMITH=2;

    public enum Apple {FUJI, PIPPIN, GRANNY_SMITH,}

    /*public enum Ensemble{
        SOLO,DUET,TRIO,QUARTET,QUINTET,
        SEXTET,SEPTET,OCTET,NONET,DECTET;

        public int numberOfMusicians() { return ordinal()+1; }
    }*/
    public enum Ensemble{
        SOLO(1),DUET(2),TRIO(3),QUARTET(4),QUINTET(5),
        SEXTET(6),SEPTET(7),OCTET(8),NONET(9),DECTET(10),
        TRIPLE_QUARTET(12);
        private final int numberOfMusicians;

        Ensemble(int size) {
            this.numberOfMusicians = size;
        }
        public int numberOfMusicians() { return numberOfMusicians; }
    }
}
