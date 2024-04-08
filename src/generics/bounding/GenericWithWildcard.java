package generics.bounding;

import java.util.ArrayList;
import java.util.List;

// wildcard(?):joker, bilinmeyen data tipi
public class GenericWithWildcard {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        List<Double> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();


        System.out.println("------------alttan sınırlama-------------");
        addElements(integers);
        System.out.println(integers);
        //addElements(doubles);
        //addElements(strings);
        addElements(numbers);
        addElements(objects);

        System.out.println("----------üstten sınırlama --------------");
        multiplyByTwo(integers);
        multiplyByTwo(doubles);
        //multiplyByTwo(strings);
        multiplyByTwo(numbers);
        //multiplyByTwo(objects);

        System.out.println("------sadece wildcard-------");
        printElements(integers);
        printElements(doubles);
        printElements(numbers);
        printElements(objects);
        printElements(strings);


    }

    //alttan sınırlama
    //listeye 1 den 10 a kadar integer elemanları ekleyen bir metod
    //list:Integer,Number,Object
    public static void addElements(List<? super Integer> list) {

        for (int i = 1; i < 11; i++) {
            list.add(i);
        }

    }

    //generic yapıyı kullanırken üstten sınırlama
    //listedeki elemanları 2 ile çarpan bir metod
    public static void multiplyByTwo(List<? extends Number> list) {

        list.stream().map(t -> 2 * t.doubleValue());

    }

    //?:bilinmeyen data tipi
    //wildcard: read-only
    //sadece data tipinden bağımsız işlemler yapılabilir
    //örn:remove,size,...
    public static void printElements(List<?> list) {//List<T> benzer

        //list.add(12);
        //list.remove(2);

        for (Object obj : list) {
            System.out.print(obj + " ");
        }

    }

//!!! NOT:List<T> ve List<?> benzer , fakat tamamen aynı değildir.

    public static <T> void addElementsToList(List<T> list, T element){
        list.add(element);
    }

}