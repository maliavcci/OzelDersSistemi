public class Ogrencirandevu {
    public static String ogrenciIsim;
    public static String ogrenciSoyisim;

    public Ogrencirandevu(String ad1,String soyad1) {
        this.ogrenciIsim = ad1;
        this.ogrenciSoyisim = soyad1;
    }
    
    public static void setOgrenciAdi(String ad1) {
        ogrenciIsim = ad1;
    }
    
    public static void setOgrenciSoyAdi(String soyad1) {
        ogrenciSoyisim = soyad1;
    }
    
    
    public Ogrencirandevu(String ad1,String soyad1,String secilengun) {
        this.ogrenciIsim = ad1;
        this.ogrenciSoyisim = soyad1;
    }
     
    public Ogrencirandevu(String ad1,String soyad1,String secilengun,int secilensaat) {
        this.ogrenciIsim = ad1;
        this.ogrenciSoyisim = soyad1;
    }
    
    
    public static String getOgrenciAdi() {
        return ogrenciIsim;
    }
    public static String getOgrenciSoyAdi() {
        return ogrenciSoyisim;
    }
    
    
    
}
