package Products;

import java.time.LocalDate;


public class Cheese extends Product implements Shippable, Expirable{
	private double weight;
	private LocalDate expirationDate;
	
	public Cheese(String name, double price, int quantity, double weight,LocalDate expirationDate){
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

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
	

}
