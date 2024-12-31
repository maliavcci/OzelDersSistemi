public class DersProgrami {
    private String ogretmenAd;
    private String ogretmenSoyad;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String gun;
    private String saat;

    public DersProgrami(String ogretmenAd, String ogretmenSoyad, String ogrenciAd, String ogrenciSoyad, String gun, String saat) {
        this.ogretmenAd = ogretmenAd;
        this.ogretmenSoyad = ogretmenSoyad;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.gun = gun;
        this.saat = saat;
    }

    @Override
    public String toString() {
        return  " Gun: " + gun + ", Saat: " + saat;
    }
}
