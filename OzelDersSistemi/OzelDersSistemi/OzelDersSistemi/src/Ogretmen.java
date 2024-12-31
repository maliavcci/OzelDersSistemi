public class Ogretmen extends Kisi {
    private String brans;

    public Ogretmen(String ad, String soyad, String brans, String parola) {
        
        super(ad, soyad, "Ogretmen", brans, parola);  // KayitTuru her zaman "Ogretmen"
        this.brans = brans;  
    }
           
    public String getBrans() {
        return brans;
    }

    @Override
    public String toString() {
        return super.toString() + " - Brans: " + brans;
    }
}
