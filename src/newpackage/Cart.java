package newpackage;
import java.util.*;
public class Cart {
    private List<CartItem> items = new ArrayList<>();
    public void add(Product product, int quantity) throws Exception {
        if (quantity > product.getQuantity())
            throw new Exception("Quantity exceeds available stock.");
        items.add(new CartItem(product, quantity));
    }
    public boolean isEmpty() { return items.isEmpty(); }
    public List<CartItem> getItems() { return items; }
}

