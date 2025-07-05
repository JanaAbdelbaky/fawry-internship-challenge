package Products;

import java.time.LocalDate;


public class Biscuits extends Product implements Shippable, Expirable{
	private LocalDate expirationDate;
	private double weight;
	
	public Biscuits(String name, double price, int quantity, double weight,LocalDate expirationDate){
		super(name,price,quantity);
		this.weight = weight;
		this.expirationDate = expirationDate;
	}

	public boolean isExpire() {
		return LocalDate.now().isAfter(expirationDate);
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
