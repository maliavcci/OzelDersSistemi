public class Kayit {
    
    public String ad;
    public String soyad;
    public int parola;

    
    public Kayit(String ad, String soyad, int parola) {
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
    }

    
    public void kayit(String ad, String soyad, int parola) {
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
        System.out.println("Kayıt başarılı: " + ad + " " + soyad);
    }

   
    public void kayit(String ad, String soyad, int parola, String Bilgi) {
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
        System.out.println("Kayıt başarılı: " + ad + " " + soyad + " - Ek Bilgi: " + Bilgi);
    }
}