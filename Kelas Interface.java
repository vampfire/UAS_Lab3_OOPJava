
interface Kendaraan {
    void info();
}


class Mobil implements Kendaraan {
    private String merek;

    public Mobil(String merek) {
        this.merek = merek;
    }

    public void info() {
        System.out.println("Ini adalah mobil " + merek);
    }
}


public class Main {
    public static void main(String[] args) {
        Kendaraan kendaraan = new Mobil("Toyota");
        kendaraan.info();
    }
}
