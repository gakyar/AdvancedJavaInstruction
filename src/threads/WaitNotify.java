package threads;

//wait-notify : thread arasında iletişimi sağlar.
//üretici(producer)-tüketici(consumer)
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

public class WaitNotify {

    public static volatile int balance=0;

    //para yatırma işlemi
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+ " para yatırmak istiyor. ");
        this.balance+=amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye : "+this.balance);
        notify();//wait ile bekleyen threade bildirim gönderilir
        notifyAll();//wait ile bekleyen tüm threadleri harekete gecirir
    }

    //para çekme işlemi
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " para çekmek istiyor. ");
        //bakiye yetersiz ise
        if (balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+this.balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();//monitör edilen objeyi geçici olarak serbest bırakılır, notify ile uyarılana kadar
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //kaldığı yerden işine devam eder
        //bakiye yeterli ise
        if (balance>=amount){
            this.balance-=amount;
            System.out.println("Para çekme işlemi başarılı. Mevcut bakiye : "+this.balance);
        }else {
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye: "+this.balance);
            System.out.println("Umudunu kaybetme:)");
        }
    }



    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("AliCan");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Veli");
        thread2.start();




    }
}