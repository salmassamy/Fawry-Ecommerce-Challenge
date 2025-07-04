package newpackage;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Salma", 1000);
            Cart cart = new Cart();
            Product cheese = new PerishableProduct("Cheese", 100, 5, LocalDate.of(2025, 12, 31));
            Product biscuits = new PerishableProduct("Biscuits", 150, 2, LocalDate.of(2025, 10, 1));
            Product tv = new ShippableProduct("TV", 300, 3, 700);
            Product scratchCard = new Product("Scratch Card", 50, 10) {};
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);
            CheckoutService.checkout(customer, cart);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}