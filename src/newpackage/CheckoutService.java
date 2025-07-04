package newpackage;
import java.util.*;
public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) throw new Exception("Cart is empty");
        double subtotal = 0;
        double shippingFee = 0;
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            if (item.quantity > p.getQuantity())
                throw new Exception("Product out of stock: " + p.getName());
            if (p instanceof PerishableProduct && ((PerishableProduct) p).isExpired())
                throw new Exception("Product expired: " + p.getName());
            subtotal += p.getPrice() * item.quantity;
            if (p instanceof Shippable) {
                shippables.add((Shippable) p);
                shippingFee += 15;
            }
            p.decreaseQuantity(item.quantity);
        }
        double total = subtotal + shippingFee;
        if (!customer.canAfford(total))
            throw new Exception("Insufficient balance.");
        customer.deductBalance(total);
        ShippingService.ship(shippables);
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.quantity + "x " + item.product.getName() + "\t" + (item.product.getPrice() * item.quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t" + subtotal);
        System.out.println("Shipping\t" + shippingFee);
        System.out.println("Amount\t" + total);
        System.out.println("Remaining balance\t" + customer.getBalance());
    }
}
