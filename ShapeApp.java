import java.util.Scanner;

// Abstract Shape Class
abstract class Shape {
    private String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

// Circle Class
class Circle extends Shape {
    private double radius;

    public Circle() {
        super("Circle");
    }

    public void setDimensions(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle Class
class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle() {
        super("Rectangle");
    }

    public void setDimensions(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double getLength() {
        return length;
    }

    public double getBreadth() {
        return breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

// Main Application
public class ShapeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Shape Area & Perimeter Calculator ===");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.print("Choose a shape: ");
        int choice = sc.nextInt();

        Shape shape = null;

        switch (choice) {
            case 1:
                shape = new Circle();
                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();
                ((Circle) shape).setDimensions(radius);
                break;
            case 2:
                shape = new Rectangle();
                System.out.print("Enter length: ");
                double length = sc.nextDouble();
                System.out.print("Enter breadth: ");
                double breadth = sc.nextDouble();
                ((Rectangle) shape).setDimensions(length, breadth);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        System.out.println("\nShape: " + shape.getShapeName());
        System.out.printf("Area: %.2f\n", shape.calculateArea());
        System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());

        sc.close();
    }
}
