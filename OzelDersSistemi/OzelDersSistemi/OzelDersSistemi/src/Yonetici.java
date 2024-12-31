import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Yonetici {
    
    private String ad;
    private String soyad;
    private String parola;
    public Yonetici(String ad, String soyad,String parola) {
        this.ad = ad;
        this.soyad = soyad;
        this.parola=parola;
    }    
    
    public String getAd() {
        return ad;
    }

    
    public String getSoyad() {
        return soyad;
    }

    
    public String getParola() {
        return parola;
    }
    
     @Override
    public String toString() {
        return "Yonetici: " + ad + " " + soyad;
    }
    
}