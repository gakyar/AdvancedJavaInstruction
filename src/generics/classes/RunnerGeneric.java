package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //generic yapıları kullanırken data tipine karar verilir
        //2 farklı nesne:laptop, book

        GenericProduct<String> book=new GenericProduct<>();//T:String
        book.setCode("advjava");

        GenericProduct<Integer> laptop=new GenericProduct<>();//T:Integer
        laptop.setCode(123456);
        //laptop.setCode("laptop");: sıkı bir tür denetimi

        String str=book.getCode();//CAST problemi kalmadı

        //  String str2=laptop.getCode();//ClassCastExc. alma riski çözüldü

        Integer code=laptop.getCode();


        //-------------------------------------------------------
        ArrayList<String> list=new ArrayList<>();

        HashMap<String,Double> hashMap=new HashMap<>();
        hashMap.put("AdvJava",99.9);
        //hashMap.put(12,23);-->CTE


        //--------------ÇOK PARAMETRELİ GENERIC CLASS----------------

        //S:String , U:Integer
        GenericClassTwoParam<String,Integer> obje=new GenericClassTwoParam<>("generic",12);


        //S:String , U:String
        GenericClassTwoParam<String,String> obje2=new GenericClassTwoParam<>("generics","harika");
        System.out.println(obje2.getDeger());

        //S:Double, U:Boolean
        GenericClassTwoParam<Double,Boolean> obje3=new GenericClassTwoParam<>(12.3,Boolean.TRUE);
        System.out.println(obje3.getAnahtar());

        System.out.println(obje3.toString());


    }






}

