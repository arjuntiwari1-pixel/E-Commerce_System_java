import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class EcommerceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Sample products
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Phone", 20000));
        products.add(new Product(3, "Headphones", 2000));

        while (true) {
            System.out.println("\n===== E-Commerce Menu =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : products) {
                        System.out.println(p.id + ". " + p.name + " - ₹" + p.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == id) {
                            cart.add(p);
                            System.out.println("Added to cart!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (Product p : cart) {
                            System.out.println(p.name + " - ₹" + p.price);
                        }
                    }
                    break;

                case 4:
                    double total = 0;
                    for (Product p : cart) {
                        total += p.price;
                    }
                    System.out.println("Total Bill: ₹" + total);
                    cart.clear();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}