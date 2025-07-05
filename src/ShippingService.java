import java.util.List;

import Cart.CartItem;
import Products.Product;
import Products.Shippable;

public class ShippingService {
	public static void ship(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        
        
        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            
            System.out.println(quantity + "x " + product.getName() + "  " + ((Shippable)product).getWeight()*quantity + "kg");
            totalWeight += ((Shippable)product).getWeight()*quantity;
        }
        
        
        System.out.println("Total package weight " + totalWeight + "kg");
    }

}
