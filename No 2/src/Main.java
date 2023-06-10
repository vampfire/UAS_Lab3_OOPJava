/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HP
 */


import java.util.ArrayList;
import java.util.List;

// Kelas abstrak untuk kendaraan
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void showInfo();
}

// Kelas mobil yang mewarisi dari Vehicle
class Car extends Vehicle {
    private int numOfDoors;

    public Car(String brand, int numOfDoors) {
        super(brand);
        this.numOfDoors = numOfDoors;
    }

    @Override
    public void showInfo() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Number of doors: " + numOfDoors);
    }

    public void repair() {
        System.out.println("Car is being repaired");
    }
}

// Interface untuk melacak maintenance kendaraan
interface MaintenanceTracker {
    void addMaintenance(String maintenance);
    void showMaintenanceHistory();
}

// Kelas untuk melacak maintenance mobil
class CarMaintenanceTracker extends Car implements MaintenanceTracker {
    private List<String> maintenanceHistory;

    public CarMaintenanceTracker(String brand, int numOfDoors) {
        super(brand, numOfDoors);
        maintenanceHistory = new ArrayList<>();
    }

    @Override
    public void addMaintenance(String maintenance) {
        maintenanceHistory.add(maintenance);
    }

    @Override
    public void showMaintenanceHistory() {
        System.out.println("Maintenance History for " + brand + ":");
        for (String maintenance : maintenanceHistory) {
            System.out.println("- " + maintenance);
        }
    }
    
    // Kelas inner untuk menghitung total biaya maintenance
    class MaintenanceCalculator {
        private double totalCost;

        public MaintenanceCalculator() {
            this.totalCost = 0.0;
        }

        public void addCost(double cost) {
            this.totalCost += cost;
        }

        public double getTotalCost() {
            return totalCost;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarMaintenanceTracker car = new CarMaintenanceTracker("Toyota", 4);
        car.showInfo();
        car.repair();
        car.addMaintenance("Oil Change");
        car.addMaintenance("Tire Rotation");
        car.showMaintenanceHistory();

        // Menggunakan inner class MaintenanceCalculator untuk menghitung total biaya maintenance
        CarMaintenanceTracker.MaintenanceCalculator calculator = car.new MaintenanceCalculator();
        calculator.addCost(100.0); // Menambah biaya maintenance
        calculator.addCost(150.0); // Menambah biaya maintenance
        double totalCost = calculator.getTotalCost();
        System.out.println("Total Maintenance Cost: $" + totalCost);
    }
}
