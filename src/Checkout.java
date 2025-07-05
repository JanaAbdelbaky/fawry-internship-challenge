import java.util.ArrayList;
import java.util.List;

import Cart.Cart;
import Cart.CartItem;
import Products.Biscuits;
import Products.Cheese;
import Products.Expirable;
import Products.MobileScratchCards;
import Products.Product;
import Products.Shippable;
import Products.TV;


public class Checkout {
	static final double SHIPPING_COST = 30.0;
	
	 public static void checkout(Customer customer, Cart cart) {
		  if (cart.isEmpty()) {
	            throw new IllegalArgumentException("Cart is empty.");
	        }

	        double totalprice = 0;
	        List<CartItem> toShip = new ArrayList<>();

	        for (CartItem item : cart.getItems()) {
	            Product product = item.getProduct();
	            int quantity = item.getQuantity();

	            if (!product.isAvailable(quantity)) {
	                throw new IllegalArgumentException(product.getName() + " is out of stock.");
	            }

	            if (product instanceof Expirable  && ((Expirable)product).isExpire() ) {
	                throw new IllegalArgumentException(product.getName() + " is expired.");
	            }

	            totalprice += product.getPrice() * quantity;
	            product.reduceQuantity(quantity);

	            if (product instanceof Shippable) {
	            	toShip.add(item);
	            }
	        }

	        double totalAmount = totalprice + SHIPPING_COST;

	        if (!customer.canAfford(totalAmount)) {
	            throw new IllegalArgumentException("Customer does not have enough balance.");
	        }

	        customer.pay(totalAmount);

	        if (!toShip.isEmpty()) {
	            ShippingService.ship(toShip);
	        }

	        System.out.println("** Checkout receipt **");
	        for (CartItem item : cart.getItems()) {
	            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + (item.getProduct().getPrice() * item.getQuantity()));
	        }
	        System.out.println("----------------------");
	        System.out.println("Subtotal " + totalprice);
	        System.out.println("Shipping " + SHIPPING_COST);
	        System.out.println("Amount " + totalAmount);
	        System.out.println("Balance remaining " + customer.getBalance());
	    
	 }
	 
	
		    public static void main(String[] args) {
		        Customer customer = new Customer("Jana", 1000);

		        Product cheese = new Cheese("Cheese", 100, 5, 0.2, false);
		        Product biscuits = new Biscuits("Biscuits", 150, 2, 0.7, false);
		        Product tv = new TV("TV", 5000, 3, 4);
		        Product scratchCard = new MobileScratchCards("Scratch Card", 50, 10);

		        Cart cart = new Cart();

		        cart.add(cheese, 2);
		        cart.add(biscuits, 1);
		        //cart.add(tv, 1);
		        cart.add(scratchCard, 1);

		        checkout(customer, cart);
		    }
		

}
