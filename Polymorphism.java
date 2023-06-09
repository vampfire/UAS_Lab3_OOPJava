/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package car;

/**
 *
 * @author HP
 */



class Mobil {
    protected String merek;
    protected String warna;

    public Mobil(String merek, String warna) {
        this.merek = merek;
        this.warna = warna;
    }

    public void tampilkanInfo() {
        System.out.println("Merek: " + merek);
        System.out.println("Warna: " + warna);
    }
}

class Sedan extends Mobil {
    private int jumlahPintu;

    public Sedan(String merek, String warna, int jumlahPintu) {
        super(merek, warna);
        this.jumlahPintu = jumlahPintu;
    }

    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}


public class Inheritance {
    public static void main(String[] args) {
        Sedan sedan = new Sedan("Toyota", "Merah", 4);
        sedan.tampilkanInfo();
    }
}
