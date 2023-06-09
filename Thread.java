class Mobil implements Runnable {
    private String merek;

    public Mobil(String merek) {
        this.merek = merek;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Mobil " + merek + " berjalan. Langkah: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Mobil("Toyota"));
        Thread thread2 = new Thread(new Mobil("Honda"));

        thread1.start();
        thread2.start();
    }
}
