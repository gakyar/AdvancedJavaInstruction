package threads;

public class Multithreading02 {

    public static int sayac = 0;

    public static void main(String[] args) {


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 11; i++) {
                    System.out.println("su satıldı");
                }

                Sayac.count();

                for (int i = 1; i < 11; i++) {
                    System.out.println("su satıldı");
                }
            }
        });
        thread1.setName("TOM");
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i < 11; i++) {
                    System.out.println("meşrubat satıldı");
                }

                Sayac.count();

                for (int i = 1; i < 11; i++) {
                    System.out.println("meşrubat satıldı");
                }

            }
        });
        thread2.setName("JERRY");
        thread2.start();


    }

}

class Sayac {

    //bu metoda threadler sırayla ulaşmalı
    public static synchronized void count() {

        for (int i = 1; i <= 1000; i++) {

            Multithreading02.sayac++;//1-okuma,2-artırma,3-atama
            System.out.println(Thread.currentThread().getName() + "-----> sayac : " + Multithreading02.sayac);//2000

        }

    }

}
