
public class Customer {
	private int id;
	private String name;
	private double balance;
	private static int next_id;
	


	public Customer(String name, double balance){
		id = next_id ++;
		this.name = name;
		this.balance = balance;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean canAfford(double balance){
		return balance <= this.balance;
	}
	
	public void pay(double balance){
		this.balance -= balance;
	}
	

}
