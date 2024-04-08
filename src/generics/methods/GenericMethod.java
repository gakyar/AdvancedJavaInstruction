package generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};

        System.out.println("---printArray metodu ile yazdırma");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("---GENERIC printArray metodu ile yazdırma");
        printArrayGeneric(intArr);
        printArrayGeneric(doubleArr);
        printArrayGeneric(stringArr);

        System.out.println("---GENERIC getFirst metodu----");
        System.out.println(getFirst(intArr));//T:Integer
        System.out.println(getFirst(doubleArr));//T:Double
        System.out.println(getFirst(stringArr));

        Integer first=getFirst(intArr);

        System.out.println("--------çoklu parametreli generic metod-------");
        printArrAndElement(intArr,"generic");//S:Integer, U:String
        printArrAndElement(intArr,12);//S:Integer, U:Integer





    }

    //arrayleri yazdırmak için metod tanımlayalım
    //farklı parametreler için:overload
    public static void printArray(Integer[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }

    public static void printArray(Double[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }
    public static void printArray(String[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();


    }

    //keşke generic metodumuz olsa
    public static <T> void printArrayGeneric(T[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();

    }

    //keşke generic metodumuz geriye generic bir data tipi döndürse
    //NOT:geriye dönüş data tipi T olmak zorunda değil
    public static <T> T getFirst(T[] arr){

        T first=arr[0];

        return first;
    }

    //birden fazla data tipiyle generic metod
    public static <S,U> void printArrAndElement(S[] arr,U element){

        // arr[0]=element;//-->farklı data tipleri olabilir!!!

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(element);



    }



}