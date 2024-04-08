package threads;
/*
bazı threadlerin main thread ve diğer threadlerden önce çalışmasını ve işini
tamamladıktan sonra diğer threadlerin kaldığı yerden devam etmesini istediğimizde
CountDownLatch classının metodları ile öncelik vermek istediğimiz
threadlerin(worker threads) sayısı kadar bir sayaç başlatıp sayaç 0 olana kadar
diğer threadler bekletilebilir.
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {
    public static void main(String[] args) {

        //task: worker threadler işini tammamlayana kadar main thread ve thread-0 beklensin

        System.out.println("Burada main thread çalışmaya başladı...");

        CountDownLatch latch=new CountDownLatch(3);
        System.out.println("Başlangıçta sayaç değeri: "+latch.getCount());


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı...");
                try {
                    latch.await();//worker threadler işini bitirene kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" çalışmaya devam ediyor...");
                System.out.println(Thread.currentThread().getName()+" işini tamamladı...");
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();//worker threadler işini bitirene kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı...");
                System.out.println(Thread.currentThread().getName()+" çalışmaya devam ediyor...");
                System.out.println(Thread.currentThread().getName()+" işini tamamladı...");
            }
        });
        thread2.start();

        WorkerThreads worker1=new WorkerThreads("A",5000,latch);
        WorkerThreads worker2=new WorkerThreads("B",7000,latch);
        WorkerThreads worker3=new WorkerThreads("C",3000,latch);
        worker1.start();
        worker2.start();
        worker3.start();


        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Burada main thread çalışmaya devam ediyor...");




    }
}

class WorkerThreads extends Thread{

    public int duration;

    public CountDownLatch latch;

    //param const
    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı....");
        //burada bazı mantıksal hesaplamalar var kabul edelim
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" işini bitirdi....");
        latch.countDown();//sayacı bir azaltır.2-1-0
        System.out.println(latch.getCount());
    }
}