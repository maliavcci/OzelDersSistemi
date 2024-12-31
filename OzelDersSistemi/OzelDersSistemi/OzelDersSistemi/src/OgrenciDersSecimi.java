import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class OgrenciDersSecimi {

    private Kasa kasa;
    private Set<String> Randevu = new HashSet<>(); 
    private List<DersProgrami> dersProgramiListesi = new ArrayList<>(); 
    private String randevuSaati;

    public OgrenciDersSecimi(Kasa kasa) {
        this.kasa = kasa;
    }

    public void saatDilimiSecim(Scanner scanner, String ogretmenAd, String ogretmenSoyad, String ogrenciAd, String ogrenciSoyad) {
        String[] gunler = {"Pazartesi", "Sali", "Carsamba", "Persembe", "Cuma"};
        int gunSecim = 0;

        while (true) {
            System.out.println("Lutfen almak istediginiz ders gununu seciniz:");
            for (int i = 0; i < gunler.length; i++) {
                System.out.println((i + 1) + ". " + gunler[i]);
            }
            gunSecim = scanner.nextInt();
            scanner.nextLine(); 
            if (gunSecim >= 1 && gunSecim <= gunler.length) {
                break;
            } else {
                System.out.println("Gecersiz bir gun sectiniz! Lutfen tekrar deneyin.");
            }
        }

        String secilenGun = gunler[gunSecim - 1];
        System.out.println("Sectiginiz gun: " + secilenGun);

        boolean saatSecildi = false;

        while (!saatSecildi) {
            System.out.println("Lutfen almak istediginiz saat dilimini seciniz:");
            System.out.println("1. 10.00-11.00");
            System.out.println("2. 11.00-12.00");
            System.out.println("3. 13.00-14.00");
            System.out.println("4. 14.00-15.00");
            System.out.println("5. 15.00-16.00");
            System.out.println("6. 16.00-17.00");
            System.out.println("7. 17.00-18.00");
            System.out.println("8. 18.00-19.00");

            int saatSecim = scanner.nextInt();
            scanner.nextLine();
            String secilenSaat = "";

            switch (saatSecim) {
                case 1:
                    secilenSaat = "10.00-11.00";
                    break;
                case 2:
                    secilenSaat = "11.00-12.00";
                    break;
                case 3:
                    secilenSaat = "13.00-14.00";
                    break;
                case 4:
                    secilenSaat = "14.00-15.00";
                    break;
                case 5:
                    secilenSaat = "15.00-16.00";
                    break;
                case 6:
                    secilenSaat = "16.00-17.00";
                    break;
                case 7:
                    secilenSaat = "17.00-18.00";
                    break;
                case 8:
                    secilenSaat = "18.00-19.00";
                    break;
                default:
                    System.out.println("Gecersiz bir saat secimi yaptiniz. Lutfen tekrar deneyin.");
                    continue;
            }

            String randevuSaati = secilenGun + " " + secilenSaat;

            
            System.out.println("Ders ucreti: 400 TL.");
            kasa.odemeYap(300);
            System.out.println("Odeme islemi basarili! Bakiyeniz guncellenmistir.");

            
            DersProgrami yeniDers = new DersProgrami(ogretmenAd, ogretmenSoyad, ogrenciAd, ogrenciSoyad, secilenGun, secilenSaat);
            dersProgramiListesi.add(yeniDers);
            saatSecildi = true; 
        }
    }

    public void dersPrograminiGoruntule() {
        System.out.println("Ders Programi:");
        for (DersProgrami ders : dersProgramiListesi) {
            System.out.println(ders);
        }
    }
}