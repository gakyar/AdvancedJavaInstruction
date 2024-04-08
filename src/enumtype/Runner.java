package enumtype;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthConstant("LOW");
        printPasswordStrengthConstant("MEDIUM");
        printPasswordStrengthConstant("GOOD");
        printPasswordStrengthConstant("PERFECT");//CTE, RTE yok, fakat istenen işlev gerçekleşmiyor!!!!!
        printPasswordStrengthConstant("");

        //ÇÖZÜM:sabit ve sınırlı sayıda değişkeni sadece parametre olarak
        //vermek:Enum Type

        System.out.println("---------------------------------------------------");

        printPasswordStrengthEnum(PasswordStrength.LOW);
        printPasswordStrengthEnum(PasswordStrength.MEDIUM);
        printPasswordStrengthEnum(PasswordStrength.HIGH);
        // printPasswordStrengthEnum();


    }

    //password gücü:LOW,MEDIUM,HIGH
    public static void printPasswordStrengthConstant(String strength){
        if (strength.equals(PasswordStrengthConstant.LOW)){
            System.out.println("Password gücünüz düşüktür.");
        } else if (strength.equals(PasswordStrengthConstant.MEDIUM)) {
            System.out.println("Password gücünüz orta seviyededir.");
        } else if (strength.equals(PasswordStrengthConstant.HIGH)) {
            System.out.println("Tebrikler, password gücünüz yüksek ");
        }
    }


    //enum type ile aynı metod
    public static void printPasswordStrengthEnum(PasswordStrength strength){
        if (strength.equals(PasswordStrength.LOW)){
            System.out.println("Password gücünüz düşüktür.");
            System.out.println("Seviye: "+strength.getLevel());

        } else if (strength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Password gücünüz orta seviyededir.");

        }else if (strength.equals(PasswordStrength.HIGH)){
            // }else if (strength.ordinal()==2){
            System.out.println("Tebrikler, password gücünüz yüksek ");
        }

        System.out.println("Enum sırası: "+strength.ordinal());
        System.out.println("Enum ismi: "+strength.name());


    }



}