package generics.interfaces;

//1. SECENEK: Generic bir interfacei implemente eden class da generic olmali

public class GenericInterfaceImpl<T> implements GenericInterface<T> {
    @Override
    public void print(T value) {

    }

    @Override
    public T find() {
        return null;
    }
}
