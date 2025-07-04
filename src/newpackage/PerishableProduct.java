package newpackage;
import java.time.LocalDate;
public class PerishableProduct extends Product {
    private LocalDate expiryDate;
    public PerishableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
