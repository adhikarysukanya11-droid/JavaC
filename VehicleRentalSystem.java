import java.util.Scanner;

// Abstract Vehicle class
abstract class Vehicle {
    private String model;
    private String registrationNumber;

    // Constructor
    public Vehicle(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    // Getters
    public String getModel() {
        return model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Abstract method
    public abstract double calculateRent(int days);

    // Overloaded method: with discount
    public double calculateRent(int days, double discountPercentage) {
        double rent = calculateRent(days);
        return rent - (rent * discountPercentage / 100);
    }
}

// Car class
class Car extends Vehicle {
    private static final double RATE_PER_DAY = 1000;

    public Car(String model, String registrationNumber) {
        super(model, registrationNumber);
    }

    @Override
    public double calculateRent(int days) {
        return RATE_PER_DAY * days;
    }
}

// Bike class
class Bike extends Vehicle {
    private static final double RATE_PER_DAY = 400;

    public Bike(String model, String registrationNumber) {
        super(model, registrationNumber);
    }

    @Override
    public double calculateRent(int days) {
        return RATE_PER_DAY * days;
    }
}

// Main application
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Choose vehicle type
        System.out.println("Choose vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        Vehicle vehicle = null;

        // Get model & registration number
        System.out.print("Enter vehicle model: ");
        String model = sc.nextLine();
        System.out.print("Enter registration number: ");
        String regNo = sc.nextLine();

        if (choice == 1) {
            vehicle = new Car(model, regNo);
        } else if (choice == 2) {
            vehicle = new Bike(model, regNo);
        } else {
            System.out.println("Invalid choice. Exiting...");
            sc.close();
            return;
        }

        // Rental days
        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        // Ask for discount
        System.out.print("Do you have a discount? (yes/no): ");
        sc.nextLine(); // consume newline
        String discountChoice = sc.nextLine();

        double totalCost;
        if (discountChoice.equalsIgnoreCase("yes")) {
            System.out.print("Enter discount percentage: ");
            double discount = sc.nextDouble();
            totalCost = vehicle.calculateRent(days, discount);
        } else {
            totalCost = vehicle.calculateRent(days);
        }

        // Display total cost
        System.out.println("\n--- Rental Summary ---");
        System.out.println("Vehicle: " + vehicle.getModel());
        System.out.println("Registration No: " + vehicle.getRegistrationNumber());
        System.out.println("Days: " + days);
        System.out.println("Total Rent: ₹" + totalCost);

        sc.close();
    }
}
