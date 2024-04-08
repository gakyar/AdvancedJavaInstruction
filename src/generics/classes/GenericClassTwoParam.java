package generics.classes;

public class GenericClassTwoParam <S,U>{

    private S anahtar;//String,Double

    private U deger;//Integer,Double

    //param const

    public GenericClassTwoParam(S anahtar, U deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }


    //getter-setter


    public S getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(S anahtar) {
        this.anahtar = anahtar;
    }

    public U getDeger() {
        return deger;
    }

    public boolean setDeger(U deger) {
        this.deger = deger;
        return false;
    }

    @Override
    public String toString() {
        return "GenericClassTwoParam{" +
                "anahtar=" + anahtar +
                ", deger=" + deger +
                '}';
    }
}