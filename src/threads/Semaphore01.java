package threads;

/*
Semaphore, n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar.

Synchronized, aynı anda ortak bir kaynağa(blok,metod) sadece 1 threadin
 erişmesine izin verir.
*/


import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(3);

        Car car1=new Car("Audi",5000,semaphore);
        Car car2=new Car("BMW",8000,semaphore);
        Car car3=new Car("Honda",2000,semaphore);
        Car car4=new Car("Toyota",3000,semaphore);
        Car car5=new Car("Porche",6000,semaphore);
        Car car6=new Car("Fiat",4000,semaphore);
        Car car7=new Car("Volvo",2000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car7.start();
    }
}

class Car extends Thread{

    public String carName;

    public int duration;

    public Semaphore semaphore;


    //param const
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }



    @Override
    public void run() {
        System.out.println(this.carName+" park etmek istiyor...");
        try {
            semaphore.acquire();//ortak kaynağa erişim iznini kontrol ediyor.
            //ortak kaynak başlangıcı
            System.out.println("--> "+this.carName+" park alanına girdi....");
            System.out.println(this.carName+" park alanında bekliyor.");
            Thread.sleep(duration);
            System.out.println("<-- "+this.carName+" park alnından ayrıldı.");
            //ortak kaynak bitişi
            semaphore.release();//izin belgesi serbest bırakılır, yani kapasite sayısı artırılır

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}