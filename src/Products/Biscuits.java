package Products;


public class Biscuits extends Product implements Shippable, Expirable{
	private boolean expire;
	private double weight;
	
	public Biscuits(String name, double price, int quantity, double weight, boolean expire){
		super(name,price,quantity);
		this.expire = expire;
		this.weight = weight;
	}

	public boolean isExpire() {
		return expire;
	}

	public void setExpire(boolean expire) {
		this.expire = expire;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
