package section10;

public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
