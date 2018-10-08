package section2;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    private static Elvis getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuilding() {}
}
