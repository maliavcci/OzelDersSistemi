public class Ogrenci extends Kisi {
    public Ogrenci(String ad, String soyad, String parola) {
        // Branş bilgisi olmadığı için null olarak geçiyoruz.Yoksa hata veriyor müller anladı
        super(ad, soyad, "Ogrenci", null, parola);
    }
}