package threads;
/*
Ölümcül kilitlenme; iki veya daha fazla threadin çalışmak için
aynı kaynağa/lara erişmek istemesiyle oluşur.

Kaynağa erişmek için sürekli birbirlerini beklemeleri sonucunda
sistem kaynakları olumsuz etkilenir ve hatta uygulama cevap veremez hale gelir.
 */
public class DeadLock {
    public static void main(String[] args) {

        String sugar="seker";
        String coffee="kahve";


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (coffee) {
                    System.out.println(Thread.currentThread().getName() + " " + coffee + " yi kullanıyor...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " i istiyor...");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName() + " " + sugar + " i kullanıyor...");
                    }//seker serbest
                }//kahve serbest
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi ve kahvesini yudumluyor...");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sugar) {
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " i kullanıyor...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + coffee + " yi istiyor...");
                    synchronized (coffee) {
                        System.out.println(Thread.currentThread().getName() + " " + coffee + " yi kullanıyor...");

                    }//kahve serbest
                }//seker serbest
                System.out.println(Thread.currentThread().getName()+" sıcak su ekledi, keyifle kahvesini içiyor...");
            }

        });
        thread2.setName("Jerry");
        thread2.start();

    }
}