import java.util.HashSet;
import java.util.Set;

public abstract class Randevu {
    private Set<RandevuDetay> doluSaatler;

    public Randevu() {
        this.doluSaatler = new HashSet<>();
    }

    public boolean saatEkle(String tarih, String saat) {
        RandevuDetay yeniRandevu = new RandevuDetay(tarih, saat);
        return doluSaatler.add(yeniRandevu);
    }

    public Set<RandevuDetay> getDoluSaatler() {
        return doluSaatler;
    }

    // Soyut bir metot ekleyelim:
    public abstract void randevuBilgisiYazdir();

    public class RandevuDetay {
        private String tarih;
        private String saat;

        public RandevuDetay(String tarih, String saat) {
            this.tarih = tarih;
            this.saat = saat;
        }

        @Override
        public String toString() {
            return "Tarih: " + tarih + ", Saat: " + saat;
        }
    }
}
