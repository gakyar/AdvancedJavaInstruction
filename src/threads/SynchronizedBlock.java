package threads;

public class SynchronizedBlock {


    //TASK: Ekrana 14 satırda [ [ [ [ [ ] ] ] ] ]
    //bu taski 2 thread içinde yapalım
    public static void main(String[] args) {

        Brackets brackets = new Brackets();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 7; i++) {
                    brackets.printBrackets();
                }

            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 7; i++) {
                    brackets.printBrackets();
                }
            }
        });

        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();
        System.out.println("Geçen süre : " + (finish - start));


    }

    //synchronized metod
    //synchronized blok


}

class Brackets {

    //bu metod bir desen oluşturduğu için kodları senkron olarak çalışmalı
    //aynı anda bu metoda sadece 1 thread erişebilmeli
    public synchronized void printBrackets() {

        //objenin çağırdığı metodda asenkron çalışabilecek kodlar varsa
        //sadece bloğu da senkron yapabiliriz.
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i < 6) {
                    System.out.print("[ ");
                } else {
                    System.out.print("] ");
                }
            }
            System.out.println(" ----> " + Thread.currentThread().getName());
        }

        //senkron olması gerekmeyen başka kodlar
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}