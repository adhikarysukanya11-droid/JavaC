import java.util.ArrayList;
import java.util.Scanner;

// Product class
class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Cart class
class Cart {
    private ArrayList<Product> cartItems = new ArrayList<>();

    // Add product to cart
    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    // Remove product from cart
    public void removeProduct(int productId) {
        for (Product product : cartItems) {
            if (product.getProductId() == productId) {
                cartItems.remove(product);
                System.out.println(product.getName() + " removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    // Display cart items
    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\n--- Your Cart ---");
        double total = 0;
        for (Product product : cartItems) {
            System.out.println(product.getProductId() + ". " + product.getName() + " - ₹" + product.getPrice());
            total += product.getPrice();
        }
        System.out.println("Total Price: ₹" + total);
    }

    // Get total price
    public double getTotalPrice() {
        double total = 0;
        for (Product product : cartItems) {
            total += product.getPrice();
        }
        return total;
    }
}

// Main application
public class ShoppingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available products
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Smartphone", 20000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Smartwatch", 5000));

        Cart cart = new Cart();

        while (true) {
            System.out.println("\n=== Online Shopping Menu ===");
            System.out.println("1. Show Available Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. Show Cart");
            System.out.println("5. Checkout & Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Products ---");
                    for (Product product : products) {
                        System.out.println(product.getProductId() + ". " + product.getName() + " - ₹" + product.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to add: ");
                    int addId = sc.nextInt();
                    boolean foundAdd = false;
                    for (Product product : products) {
                        if (product.getProductId() == addId) {
                            cart.addProduct(product);
                            foundAdd = true;
                            break;
                        }
                    }
                    if (!foundAdd) System.out.println("Invalid Product ID.");
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeProduct(removeId);
                    break;

                case 4:
                    cart.showCart();
                    break;

                case 5:
                    System.out.println("\n=== Checkout ===");
                    cart.showCart();
                    System.out.println("Thank you for shopping with us!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
