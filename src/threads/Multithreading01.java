package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        //TASK: 1 den 10 a 2 defa kadar sayalım:main thread

//        long start=System.currentTimeMillis();
//
//        Counter counter1=new Counter("Hakan");
//        Counter counter2=new Counter("Ahmet");
//        counter1.count();
//        counter2.count();
//
//        long finish=System.currentTimeMillis();
//
//        System.out.println("Main thread ile geçen süre: "+(finish-start));//10252

        //TASK: 1 den 10 a 2 defa kadar sayalım:multithread
        System.out.println("-------------------multithreading-----------------------------");

        long start2=System.currentTimeMillis();

        Thread thread1=new CounterThread("Selim");
        Thread thread2=new CounterThread("Fatma");
        Thread thread3=new CounterThread("Ali");
        thread1.start();
        thread2.start();
        thread3.start();


        //main thread thread1 ve thread2 işini bitirene kadar beklemeli
        try {
            thread1.join();//thread1 işini bitirene kadar main threadi bekletir
            thread2.join();//thread2 işini bitirene kadar main threadi bekletir
            thread3.join();//thread3 işini bitirene kadar main threadi bekletir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        long finish2=System.currentTimeMillis();
        System.out.println("Multi thread ile geçen süre: "+(finish2-start2));//10252





    }
}
class Counter{

    public String name;

    //param const
    public Counter(String name) {
        this.name = name;
    }

    //1den 10 a kadar yazdıralım
    public void count(){

        for (int i=1;i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+"  -  "+this.name);
        }

    }
}

//aynı taski multithreading ile yapalım

class CounterThread extends Thread{

    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    //1den 10 a kadar yazdıralım
    public void count(){

        for (int i=1;i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+"  -  "+this.name);
        }

    }

    @Override
    public void run() {//threade saydırma işlemi yaptıralım
        count();
    }
}