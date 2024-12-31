public class Kasa {
    private double bakiye;

    public Kasa() {
        this.bakiye = 0.0;
    }

    public void odemeYap(double miktar) {
        this.bakiye += miktar;
    }

    public double getBakiye() {
        return bakiye;
    }
}
