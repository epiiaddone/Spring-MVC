package controllers;

import java.util.HashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




public class Order {
	
	@NotEmpty(message = "is required")
	@Size(max=30)
	private String firstLineAddress;
	
	@Size(max=20)
	private String firstName;
	
	@NotEmpty(message = "is required")
	@Size(max=20)
	private String lastName;
	
	@NotEmpty
	@Size(min=6, max=8)
	@Pattern(regexp="[a-zA-Z][a-zA-z][0-9]{1,2} ?[0-9][a-zA-Z]{2}", message="Invalid")
	private String postCode;
	
	private String discountCode;
	
	@NotEmpty(message = "is required")
	private String delivery;
	
	@NotEmpty(message = "is required")
	private String[] selected;
	
	private double price;
	
	private HashMap<String, Double> products;
	
	private HashMap<String, Double> deliveries;
	
	private HashMap<String, Double> discounts;
	
	public Order() {
		
		// product prices - would be better to get from separate file
	products = new HashMap<>();
	products.put("product 1", 80.00);
	products.put("product 2", 100.00);
	products.put("product 3", 150.00);
	
	// delivery prices - would be better to get form separate file
	deliveries = new HashMap<>();
	deliveries.put("Next Day", 5.00);
	deliveries.put("1st Class", 3.50);
	deliveries.put("Standard",  2.50);
	
	// discounts - would be better to get from separate file
	discounts = new HashMap<>();
	discounts.put("CODE1",  0.85);
	discounts.put("CODE2", 0.75);
	discounts.put("None",  1.00);
		}
	
	
	
	
	public HashMap<String, Double> getDiscounts() {
		return discounts;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public HashMap<String, Double> getProducts() {
		return products;
	}




	public HashMap<String, Double> getDeliveries() {
		return deliveries;
	}




	public String getFirstLineAddress() {
		return firstLineAddress;
	}

	public void setFirstLineAddress(String firstLineAddress) {
		this.firstLineAddress = firstLineAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String[] getSelected() {
		return selected;
	}

	public void setSelected(String[] selected) {
		this.selected = selected;
	}

	
	

	
	
	

}
