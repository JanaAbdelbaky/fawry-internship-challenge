package Cart;
import java.util.ArrayList;
import java.util.List;

import Products.Expirable;
import Products.Product;


public class Cart {
	private List<CartItem> items = new ArrayList<>();

	public List<CartItem> getItems() {
		return items;
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public void add(Product product, int quantity){
		if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Product " + product.getName() + " does not have enough quantity.");
        }
		 if (product instanceof Expirable  && ((Expirable)product).isExpire() ) {
             throw new IllegalArgumentException(product.getName() + " is expired.");
         }
        items.add(new CartItem(product, quantity));
    }	
}
