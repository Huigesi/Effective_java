package section11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Foo extends AbstractFoo implements Serializable {
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();

        int x=stream.readInt();
        int y=stream.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(getX());
        stream.writeInt(getY());
    }

    public Foo(int x, int y) {
        super(x, y);
    }
    private static final long serialVersionUID=1856835860954L;
}
