public class Kisi {
    private String ad;
    private String soyad;
    private String parola;
    private String kayitTuru;
    private String brans;  

    public Kisi(String ad, String soyad, String kayitTuru, String brans, String parola) {
        this.ad = ad;
        this.soyad = soyad;
        this.kayitTuru = kayitTuru;
        this.parola = parola;
        this.brans = brans;  
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getKayitTuru() {
        return kayitTuru;
    }

    public String getParola() {
        return parola;
    }

    public String getBrans() {
        return brans;  
    }

    @Override
    public String toString() {
        if (brans != null) {
            return kayitTuru + ": " + ad + " " + soyad + " - Brans: " + brans;
        } else {
            return kayitTuru + ": " + ad + " " + soyad;
        }
    }
}
