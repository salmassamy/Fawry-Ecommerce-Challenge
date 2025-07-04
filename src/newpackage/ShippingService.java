package newpackage;
import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable> shippables) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (Shippable s : shippables) {
            System.out.println(s.getName() + "\t" + s.getWeight() + "g");
            totalWeight += s.getWeight();
        }
        System.out.println("Total package weight: " + totalWeight / 1000 + "kg\n");
    }
}
