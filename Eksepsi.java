class Mobil {
    private String merek;

    public Mobil(String merek) {
        this.merek = merek;
    }

    public void start() throws Exception {
        if (merek.equals("Toyota")) {
            throw new Exception("Mobil " + merek + " tidak dapat dinyalakan.");
        } else {
            System.out.println("Mobil " + merek + " dinyalakan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota");

        try {
            mobil.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
