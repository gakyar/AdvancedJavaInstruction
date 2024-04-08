package generics.interfaces.examle;
//Uygulamadaki tum repolar icin standart
public interface Repo<T> {

    void save(T obj);

    T find();
}
