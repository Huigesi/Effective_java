package section11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public final class StringList implements Serializable {
    private transient int size=0;
    private transient Entry head = null;

    private static class Entry{
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {

    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size);
        for (Entry e = head; e != null; e = e.next) {
            stream.writeObject(e.data);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int numElements = stream.readInt();
        for (int i = 0; i < numElements; i++) {
            add((String) stream.readObject());
        }

    }
}
