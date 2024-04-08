package threads;

public class Volatile01 {
    public volatile static int flag = 1;// flag cache e alınıyor

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {//1. cekirdekte
            @Override
            public void run() {
                while (flag==0){
                    System.out.println("bu sadece bir risk");
                }

            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {//2. cekirdekte
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("flag:1 oldu dongu duracak!");

            }
        });
        thread2.start();

    }
}
