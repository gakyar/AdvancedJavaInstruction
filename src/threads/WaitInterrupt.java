package threads;

/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/

//multi threading uygulamalarda bir threadin işini sürdürebilmesi için
//diğer bir threadin çalışması gerekiyorsa wait/notify veya wait/interrupt ile
//iletişim sağlanabilir
public class WaitInterrupt {

    public static volatile int balance=0;

    //para yatırma işlemi
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+ " para yatırmak istiyor. ");
        this.balance+=amount;
        System.out.println("Para yatırma işlemi başarılı, mevcut bakiye : "+this.balance);
    }

    //para çekme işlemi
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " para çekmek istiyor. ");
        //bakiye yetersiz ise
        if (balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!!! Mevcut bakiye : "+this.balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Bakiye güncellendi,isleme devam ediliyor");            }
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
        WaitInterrupt obj=new WaitInterrupt();

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
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt();//thread1 in bekleme işini zorla durdurur
            }
        });
        thread2.setName("üretici");
        thread2.start();

    }

}