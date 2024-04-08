package generics.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
//cozum: generic bir product class

//!!!!!!generic olarak sadece NON-PRIMITIVE data tipi kullanılabilir!(int,double kullanılamaz)

/*
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
      */
public class GenericProduct<T> {

    private  T code;//T: herhangi bir no primitive data tipini temsil ediyor

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
