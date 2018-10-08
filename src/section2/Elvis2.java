package section2;

public class Elvis2 {
    private static Elvis2 ourInstance = new Elvis2();

    public static Elvis2 getInstance() {
        return ourInstance;
    }

    private Elvis2() {
    }
    public void leaveTheBuilding() {}
}
