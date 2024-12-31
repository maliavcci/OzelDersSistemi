import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class SistemYonetimi {
        
    private ArrayList<Kisi> kullanicilar;
    private HashMap<Kisi, String> sifreler; 
    private List<String> ogretmenIsimleri;
    private List<String> ogrenciIsimleri;
    private List<String> calisanIsimleri;
    private List<Ogrenci> kayitliOgrenciler = new ArrayList<>();
    private List<Ogretmen> kayitliOgretmenler;

    
    public SistemYonetimi() {
        kullanicilar = new ArrayList<>();
        sifreler = new HashMap<>();
        ogretmenIsimleri=new ArrayList<>();
        ogrenciIsimleri=new ArrayList<>();
        calisanIsimleri=new ArrayList<>();
        this.kayitliOgretmenler = new ArrayList<>();
        
        calisanIsimleri.add("Omer Faruk Damar");
        calisanIsimleri.add("Emir Sagli");
        ogrenciIsimleri.add("Mustafa Kaplan");
        ogrenciIsimleri.add("Osman Ozcan");
        ogrenciIsimleri.add("Yasin Korkmaz");
        ogrenciIsimleri.add("Sevgi Erdogan");
        ogrenciIsimleri.add("Ayse Ates");
        ogrenciIsimleri.add("Songul Simsek");
        ogretmenIsimleri.add("Ahmet Aksoy");
        ogretmenIsimleri.add("Yasin Aktas");
        ogretmenIsimleri.add("Ugur Tas");
        ogretmenIsimleri.add("Mustafa Aksoy");
        ogretmenIsimleri.add("Onur Korkmaz");
        ogretmenIsimleri.add("Salih Cakir");
        ogretmenIsimleri.add("Murat Cetin");
        ogretmenIsimleri.add("Furkan Kaya");
        ogretmenIsimleri.add("Ayten Guler");
        ogretmenIsimleri.add("Sultan Kilic");
        ogretmenIsimleri.add("Meryem Korkmaz");
        ogretmenIsimleri.add("Havva Aydin");
        ogretmenIsimleri.add("Sultan Bozkurt");
        ogretmenIsimleri.add("Hava Aydin");
        ogretmenIsimleri.add("Rukiye Yilmaz");
        ogretmenIsimleri.add("Ayse Arslan");
    }
    public boolean calisanDogrula(String ad, String soyad, String parola) {
    for (Kisi kisi : kullanicilar) {
        if (kisi.getKayitTuru().equalsIgnoreCase("Calisan") &&
            kisi.getAd().equalsIgnoreCase(ad) &&
            kisi.getSoyad().equalsIgnoreCase(soyad) &&
            sifreler.get(kisi).equals(parola)) {
            return true;
        }
    }
    return false;
}
    
    
     public boolean ogretmenDogrula(String ad, String soyad,String brans, String parola) {
    for (Kisi kisi : kullanicilar) {
        if (kisi.getKayitTuru().equalsIgnoreCase("Ogretmen") &&
            kisi.getAd().equalsIgnoreCase(ad) &&
            kisi.getSoyad().equalsIgnoreCase(soyad) &&
            sifreler.get(kisi).equals(parola)) {
            return true;
        }
    }
    return false;
}
    
    
    
   public boolean ogrenciDogrula(String ad, String soyad, String parola) {
    for (Kisi kisi : kullanicilar) {
        if (kisi.getKayitTuru().equalsIgnoreCase("Ogrenci") &&
            kisi.getAd().equalsIgnoreCase(ad) &&
            kisi.getSoyad().equalsIgnoreCase(soyad) &&
            sifreler.get(kisi).equals(parola)) {
            return true;
        }
    }
    return false;
}


    public void ogrencileriListele() {
    System.out.println("Kaydedilen Ogrenciler:");
    for (Kisi kisi : kullanicilar) {
        if (kisi.getKayitTuru().equalsIgnoreCase("Ogrenci")) {
            System.out.println("Ad: " + kisi.getAd() +
                               ", Soyad: " + kisi.getSoyad() +
                               ", Parola: " + sifreler.get(kisi));
        }
    }
}
    public void kayitliCalisanlariEkle(){
        String[][] calisanlar={
        {"Omer Faruk","Damar","UrYbE0nX"},
        {"Emir","Sagli","c7dNHYo7"}
        };
    
    for(String[] calisan: calisanlar){
           String ad=calisan[0];
           String soyad=calisan[1];
           String parola=calisan[2];
           
           Kisi yeniCalisan=new Kisi(ad,soyad,"Calisan",null,parola);
           kullanicilar.add(yeniCalisan);
           sifreler.put(yeniCalisan, parola);
    }
    };
    public void kayitliOgrencileriEkle() {
    String[][] ogrenciler = {
        {"Mustafa", "Kaplan", "wEt7RbjS"},
        {"Osman", "Ozcan", "G421FG7h"},
        {"Yasin", "Korkmaz", "6hlMFuWr"},
        {"Sevgi", "Erdogan", "lTH8y1P4"},
        {"Ayse", "Ates", "G1ufAnX6"},
        {"Songul", "Simsek", "QsBIrnhg"}
    };
    for (String[] ogrenci : ogrenciler) {
            String ad = ogrenci[0];
            String soyad = ogrenci[1];
            String parola = ogrenci[2];
            Ogrenci yeniOgrenci = new Ogrenci(ad, soyad, parola);
            
            kullanicilar.add(yeniOgrenci);
            sifreler.put(yeniOgrenci, parola);
        }
    }
    
   
    public void kayitliOgretmenleriEkle() {
    Ogretmen[] ogretmenler = {
        new Ogretmen("Ahmet", "Aksoy", "Matematik", "60VnVeII"),
        new Ogretmen("Yasin", "Aktas", "Fizik", "88DQFGXq"),
        new Ogretmen("Ugur", "Tas", "Kimya", "Hjjk7ZWi"),
        new Ogretmen("Mustafa", "Aksoy", "Turk Dili ve Edebiyati", "9sINdteM"),
        new Ogretmen("Onur", "Korkmaz", "Biyoloji", "fUoG6KHe"),
        new Ogretmen("Salih", "Cakir", "Tarih", "RSTbrQyX"),
        new Ogretmen("Murat", "Cetin", "Cografya", "HMzKNfva"),
        new Ogretmen("Furkan", "Kaya", "Matematik", "FrnsorrS"),
        new Ogretmen("Ayten", "Guler", "Fizik", "craHmvyX"),
        new Ogretmen("Sultan", "Kilic", "Kimya", "II5LvOVZ"),
        new Ogretmen("Meryem", "Korkmaz", "Turk Dili ve Edebiyati", "EkXBtuNA"),
        new Ogretmen("Havva", "Aydin", "Biyoloji", "6KyFuXHL"),
        new Ogretmen("Sultan", "Bozkurt", "Tarih", "uW27M265"),
        new Ogretmen("Hava", "Aydin", "Cografya", "58cJ7oqF")
    };

    for (Ogretmen ogretmen : ogretmenler) {
        kullanicilar.add(ogretmen);  
        sifreler.put(ogretmen, ogretmen.getParola());  
    }
}

    
    public List<Ogretmen> bransaGoreOgretmenleriGetir(String brans) {
    List<Ogretmen> uygunOgretmenler = new ArrayList<>();
    for (Kisi kisi : kullanicilar) {
        if (kisi instanceof Ogretmen) {
            Ogretmen ogretmen = (Ogretmen) kisi;
            if (ogretmen.getBrans().equalsIgnoreCase(brans)) {
                uygunOgretmenler.add(ogretmen);
            }
        }
    }
    return uygunOgretmenler;
}

    
    private String rastgeleParola() {
        String karakterler = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sifre = new StringBuilder();
        for (int i = 0; i < 8; i++) { 
            sifre.append(karakterler.charAt(random.nextInt(karakterler.length())));
        }
        return sifre.toString();
    }

    public void kullaniciEkle(String ad, String soyad, String kayitTuru,String brans) {
        String parola = rastgeleParola();
        Kisi yeniKullanici = new Kisi(ad, soyad, kayitTuru,brans,parola);       
        kullanicilar.add(yeniKullanici);
        sifreler.put(yeniKullanici, parola);
        System.out.println("Kullanici basariyla eklendi: " + yeniKullanici);
        System.out.println("Parola: " + parola);
    }

   
    public void kullanicilariListele(boolean yoneticiGirisiYapildiginda) {
    if (kullanicilar.isEmpty()) {
        System.out.println("Hicbir kullanici kaydedilmemis.");
    } else {
        System.out.println("Kaydedilen Kullanicilar:");
        for (Kisi kisi : kullanicilar) {
            if (yoneticiGirisiYapildiginda || !kisi.getKayitTuru().equalsIgnoreCase("Ogretmen")) {
                String bilgiler = "Ad: " + kisi.getAd() +
                                 " Soyad: " + kisi.getSoyad() +
                                 " Tur: " + kisi.getKayitTuru();
                
                if (kisi instanceof Ogretmen) {
                    bilgiler += ", Brans: " + ((Ogretmen) kisi).getBrans();
                }
                
                if (sifreler.containsKey(kisi)) {
                    bilgiler += ", Parola: " + sifreler.get(kisi); 
                }

                
                System.out.println(bilgiler);
            }
        }
    }       
}

}