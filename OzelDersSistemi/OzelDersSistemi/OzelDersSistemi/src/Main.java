import java.util.List;
import java.util.Scanner;

class MesajClass{
    
    static String karsilama = "************************Ozel Ders Sistemine Hosgeldiniz*************************************";

    
    static class StaticIcIce{
        
        void mesajYazdirma(){
            System.out.println(karsilama);
        }}}
    public class Main {
    private Scanner scanner;
    private String ad1;
    private String soyad1;
    public Main() {
        this.scanner = new Scanner(System.in);
    }
    public static void main(String[] args) {
                                
        int secim=0;
        boolean giris = false;
        boolean yoneticiGirisiYapildiginda=false;
        Yonetici yonetici=new Yonetici("Mehmetali", "Avci", "mehmet123");
        SistemYonetimi sistemYonetimi = new SistemYonetimi();
        Kasa kasa = new Kasa();
        OgrenciDersSecimi ogrenciDersSecimi = new OgrenciDersSecimi(kasa);
        sistemYonetimi.kayitliOgretmenleriEkle();
        sistemYonetimi.kayitliOgrencileriEkle();
        sistemYonetimi.kayitliCalisanlariEkle();
        Scanner scanner = new Scanner(System.in);
        String islemler="1.Ogrenci\n"+"2.Yonetici\n"+"3.Calisan\n"+"4.Ogretmen\n"+"5.Cikis";
               
        MesajClass.StaticIcIce m1 = new MesajClass.StaticIcIce();
        m1.mesajYazdirma();
        while(true){
        System.out.println("Yapmak Istediginiz Girisi Secin veya Sistemden Cikis Yapiniz....");
        System.out.println(islemler);
        secim=scanner.nextInt();
        scanner.nextLine();
                
       switch (secim) {            
    case 1:
        giris = false;    
        while (!giris) {
            System.out.println("Lutfen ogrenci girisi yapiniz.");
            
            try {
                String ogrenciAd = "";
                while (ogrenciAd.isEmpty()) {
                    System.out.print("Ad: ");
                    ogrenciAd = scanner.nextLine();
                    if (ogrenciAd.isEmpty()) {
                        throw new BoslukIstisnaException("Ad bos birakilamaz. Lutfen gecerli bir ad giriniz.");
                    }
                }

                String ogrenciSoyad = "";
                while (ogrenciSoyad.isEmpty()) {
                    System.out.print("Soyad: ");
                    ogrenciSoyad = scanner.nextLine();
                    if (ogrenciSoyad.isEmpty()) {
                        throw new BoslukIstisnaException("Soyad bos birakilamaz. Lutfen gecerli bir soyad giriniz.");
                    }
                }

                Ogrencirandevu ogr = new Ogrencirandevu(ogrenciAd, ogrenciSoyad);        
                Ogrencirandevu.setOgrenciAdi(ogrenciAd);
                
                String ogrenciParola = "";
                while (ogrenciParola.isEmpty()) {
                    System.out.print("Parola: ");
                    ogrenciParola = scanner.nextLine();
                    if (ogrenciParola.isEmpty()) {
                        throw new BoslukIstisnaException("Parola bos birakilamaz. Lutfen gecerli bir parola giriniz.");
                    }
                }

                if (!sistemYonetimi.ogrenciDogrula(ogrenciAd, ogrenciSoyad, ogrenciParola)) {
                    System.out.println("Hatali giris yaptiniz! Giris Secimine Geri Donuyorsunuz....");
                    break;
                } else {
                    giris = true;
                }
            } catch (BoslukIstisnaException e) {
                System.out.println(e.getMessage());
            }
        }

        if (giris) {
            System.out.print("Basariyla giris yaptiniz!! Hosgeldiniz!!");
            System.out.print(" ");
            System.out.print("Ogrenci Adi: " + Ogrencirandevu.getOgrenciAdi());
            System.out.print(" ");
            System.out.println("Ogrenci Soyadi: " + Ogrencirandevu.getOgrenciSoyAdi());
            int sinif = 0;
            while (true) {
                System.out.println("Lutfen almak istediginiz sinifi seciniz (9-10-11-12): ");
                sinif = scanner.nextInt();
                scanner.nextLine(); 
                if (sinif >= 9 && sinif <= 12) {
                    break;
                } else {
                    System.out.println("Gecersiz bir sinif girdiniz! Lutfen 9, 10, 11 veya 12 siniflarindan birini secin.");
                }
            }

            String brans = null;
            while (true) {
                System.out.println("Lutfen almak istediginiz dersi seciniz (Matematik, Fizik, Kimya, Biyoloji, Tarih, Cografya, Turk Dili ve Edebiyati): ");
                brans = scanner.nextLine();
                if (brans.equalsIgnoreCase("Matematik") || brans.equalsIgnoreCase("Fizik") ||
                    brans.equalsIgnoreCase("Kimya") || brans.equalsIgnoreCase("Biyoloji") ||
                    brans.equalsIgnoreCase("Tarih") || brans.equalsIgnoreCase("Cografya") ||
                    brans.equalsIgnoreCase("Turk Dili ve Edebiyati")) {
                    break;
                } else {
                    System.out.println("Gecersiz bir ders girdiniz! Lutfen yukaridaki derslerden birini secin.");
                }
            }

            List<Ogretmen> uygunOgretmenler = sistemYonetimi.bransaGoreOgretmenleriGetir(brans);
            if (uygunOgretmenler.isEmpty()) {
                System.out.println("Maalesef " + brans + " dersi icin uygun bir ogretmen bulunmamaktadir.");
            } else {
                System.out.println(brans + " dersi icin uygun ogretmenler:");
                for (int i = 0; i < uygunOgretmenler.size(); i++) {
                    System.out.println((i + 1) + ". " + uygunOgretmenler.get(i).getAd() + " " + uygunOgretmenler.get(i).getSoyad());
                }

                int ogretmenSecim = 0;
                while (true) {
                    System.out.print("Lutfen bir ogretmen seciniz (1-" + uygunOgretmenler.size() + "): ");
                    ogretmenSecim = scanner.nextInt();
                    scanner.nextLine(); 
                    if (ogretmenSecim >= 1 && ogretmenSecim <= uygunOgretmenler.size()) {
                        break;
                    } else {
                        System.out.println("Gecersiz bir secim yaptiniz! Lutfen tekrar deneyin.");
                    }
                }

                Ogretmen secilenOgretmen = uygunOgretmenler.get(ogretmenSecim - 1);
                System.out.println("Seciminiz: " + secilenOgretmen.getAd() + " " + secilenOgretmen.getSoyad() + ". Iyi dersler dileriz!");
                
                ogrenciDersSecimi.saatDilimiSecim(scanner,"","","","");
            }
        }
        break;
                case 2:                    
                    while (!yoneticiGirisiYapildiginda) {
                        System.out.println("Lutfen yonetici girisi yapiniz.");
                        System.out.print("Ad: ");
                        String yoneticiAd = scanner.nextLine();
                        System.out.print("Soyad: ");
                        String yoneticiSoyad = scanner.nextLine();
                        System.out.print("Parola: ");
                        String yoneticiParola = scanner.nextLine();

                        if (!yoneticiAd.equals(yonetici.getAd()) || !yoneticiSoyad.equals(yonetici.getSoyad()) || !yoneticiParola.equals(yonetici.getParola())) {
                            System.out.println("Hatali giris yaptiniz! Giris Secimine Geri Donuyorsunuz....");
                            break;
                        } else {
                             yoneticiGirisiYapildiginda = true;
                        }
                    }

                    if (yoneticiGirisiYapildiginda) {
                        System.out.println("Basariyla giris yaptiniz. Hosgeldiniz, " + yonetici.getAd() + "!");
                        boolean yoneticiSistemindenCikma = false;

                        while (!yoneticiSistemindenCikma) {
                            System.out.println("\n***Yonetici Sistemi**");
                            System.out.println("1. Kullanici Ekle");
                            System.out.println("2. Kullanicilari Listele");
                            System.out.println("3. Bakiyeyi Gor");
                            System.out.println("4. Cikis");
                            System.out.print("Seciminiz: ");
                            secim = scanner.nextInt();
                            scanner.nextLine();

                            switch (secim) {
                                case 1:
                                    System.out.print("Ad: ");
                                    String ad = scanner.nextLine();
                                    System.out.print("Soyad: ");
                                    String soyad = scanner.nextLine();
                                    System.out.print("Tur (Ogrenci/Ogretmen/Calisan): ");
                                    String kayitTuru = scanner.nextLine();
                                    String brans=null;
                                    if (kayitTuru.equalsIgnoreCase("Ogretmen")) {
                                        System.out.println("Brans secin: Matematik, Fizik, Kimya, Turk Dili ve Edebiyati, Biyoloji, Tarih, Cografya");
                                        while (true) {
                                            brans = scanner.nextLine();
                                            if (brans.equalsIgnoreCase("Matematik") || brans.equalsIgnoreCase("Fizik") || brans.equalsIgnoreCase("Kimya")
                                                    || brans.equalsIgnoreCase("Turk Dili ve Edebiyati") || brans.equalsIgnoreCase("Biyoloji")
                                                    || brans.equalsIgnoreCase("Tarih") || brans.equalsIgnoreCase("Cografya")) {
                                                break;
                                            } else {
                                                System.out.println("Gecersiz brans girdiniz! Lutfen gecerli bir brans giriniz.");
                                            }
                                        }
                                    }                                                                                                          
                                    if (kayitTuru.equalsIgnoreCase("Ogrenci") || kayitTuru.equalsIgnoreCase("Ogretmen") || kayitTuru.equalsIgnoreCase("Calisan")) {
                                        sistemYonetimi.kullaniciEkle(ad, soyad, kayitTuru,brans);
                                    } else {
                                        System.out.println("Gecersiz tur girdiniz!!! Lutfen 'Ogrenci', 'Ogretmen' veya 'Calisan' giriniz.");
                                    }
                                    break;
                                case 2:                                   
                                    sistemYonetimi.kullanicilariListele(true);
                                    break;
                                case 3:
                                    System.out.println("Guncel bakiye: " + kasa.getBakiye() + " TL");
                                    break;
                                case 4:
                                    System.out.println("Yonetici Sisteminden Cikiliyor...");
                                    yoneticiSistemindenCikma = true;
                                    yoneticiGirisiYapildiginda = false;
                                    break;
                                default:
                                    System.out.println("Gecersiz secim girdiniz! Tekrar deneyin.");
                                    break;
                            }                            
                        }
                    }
                    break;
                case 3:
                    giris = false;
                    while (!giris) {
                        System.out.println("Lutfen calisan girisi yapin.");
                        System.out.print("Ad: ");
                        String calisanAd = scanner.nextLine();
                        System.out.print("Soyad: ");
                        String calisanSoyad = scanner.nextLine();
                        System.out.print("Parola: ");
                        String calisanParola = scanner.nextLine();

                        if (sistemYonetimi.calisanDogrula(calisanAd, calisanSoyad, calisanParola)) {
                            giris = true;
                        } else {
                            System.out.println("Hatali giris yaptiniz!");
                            break;
                        }
                    }

                    if (giris) {
                        System.out.println("Basariyla giris yaptiniz. Hosgeldiniz!");
                        while (true) {
                            System.out.println("\n**Calisan Sistemi**");
                            System.out.println("1. Ogrenci Ekle");
                            System.out.println("2. Ogrencileri Listele");
                            System.out.println("3. Cikis");
                            System.out.print("Seciminiz: ");
                            secim = scanner.nextInt();
                            scanner.nextLine();

                            switch (secim) {
                                case 1:
                                    System.out.print("Ogrenci Adi: ");
                                    String ad = scanner.nextLine();
                                    if(ad=="" || ad==" "){
                                        System.out.println("Hatali giris yaptiniz!!!");
                                        break;
                                    }
                                    System.out.print("Ogrenci Soyadi: ");
                                    String soyad = scanner.nextLine();
                                    if(soyad=="" || soyad==" "){
                                        System.out.println("Hatali giris yaptiniz!!!");
                                        break;
                                    }
                                    sistemYonetimi.kullaniciEkle(ad, soyad, "Ogrenci", null);
                                    break;
                                case 2:
                                    sistemYonetimi.ogrencileriListele();
                                    break;
                                case 3:
                                    System.out.println("Calisan sisteminden cikiliyor...");
                                    break;
                                default:
                                    System.out.println("Gecersiz secim girdiniz! Tekrar deneyin.");
                            }
                            if (secim == 3) break;
                        }
                    }
                    break;
                case 4:
    giris = false;
    while (!giris) {
        System.out.println("Lutfen ogretmen girisi yapin.");
        
        try {
            String ogretmenAd = "";
            while (ogretmenAd.isEmpty()) {
                System.out.print("Ad: ");
                ogretmenAd = scanner.nextLine();
                if (ogretmenAd.isEmpty()) {
                    throw new BoslukIstisnaException("Ad bos birakilamaz. Lutfen gecerli bir ad giriniz.");
                }
            }

            String ogretmenSoyad = "";
            while (ogretmenSoyad.isEmpty()) {
                System.out.print("Soyad: ");
                ogretmenSoyad = scanner.nextLine();
                if (ogretmenSoyad.isEmpty()) {
                    throw new BoslukIstisnaException("Soyad bos birakilamaz. Lutfen gecerli bir soyad giriniz.");
                }
            }

            String ogretmenBrans = "";
            while (ogretmenBrans.isEmpty()) {
                System.out.print("Brans: ");
                ogretmenBrans = scanner.nextLine();
                if (ogretmenBrans.isEmpty()) {
                    throw new BoslukIstisnaException("Brans bos birakilamaz. Lutfen gecerli bir brans giriniz.");
                }
            }

            String ogretmenParola = "";
            while (ogretmenParola.isEmpty()) {
                System.out.print("Parola: ");
                ogretmenParola = scanner.nextLine();
                if (ogretmenParola.isEmpty()) {
                    throw new BoslukIstisnaException("Parola bos birakilamaz. Lutfen gecerli bir parola giriniz.");
                }
            }

            if (sistemYonetimi.ogretmenDogrula(ogretmenAd, ogretmenSoyad, ogretmenBrans, ogretmenParola)) {
                giris = true;
            } else {
                System.out.println("Hatali giris yaptiniz!");
                break;
            }

        } catch (BoslukIstisnaException e) {
            System.out.println(e.getMessage());
        }
    }

    if (giris) {
        System.out.println("Basariyla giris yaptiniz. Hosgeldiniz!");
        while (true) {
            System.out.println("\n*Ogretmen Sistemi*");
            System.out.println("1. Ders Programini Goruntule");
            System.out.println("2. Bakiye Goruntule");
            System.out.println("3. Cikis");
            System.out.print("Seciminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Ogrenci Adi: " + Ogrencirandevu.getOgrenciAdi());
                    System.out.println("Ogrenci Soyadi: " + Ogrencirandevu.getOgrenciSoyAdi());
                    ogrenciDersSecimi.dersPrograminiGoruntule(); // Ders programını görüntüle
                    break;
                    case 2:
                    System.out.println(kasa.getBakiye()/3);
                    break;
                case 3:
                    System.out.println("Ogretmen sisteminden cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim girdiniz! Tekrar deneyin.");
            }
            if (secim == 3) break;
        }
    }
    break;

                case 5:
                    System.out.println("Sistemden cikiliyor...");
                    scanner.close();
                    return;
                default:
                    throw new RuntimeException("Ekrana hatali deger girdiniz Programi tekrardan baslatin...");                   
            }        
        }                     
    }
}