package controllers;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// This Class is testing that the order price is calculated correctly. 

@RunWith(Parameterized.class)
public class OrderControllerTest{
	
	private Order testOrder;
	private String testDelivery;
	private String testDiscountCode;
	private String[] testSelected;
	private Double testPrice;
	
	
	public OrderControllerTest
	(String testDelivery, String testDiscountCode, String[] testSelected, Double testPrice) {
		super();
		this.testDelivery = testDelivery;
		this.testDiscountCode = testDiscountCode;
		this.testSelected = testSelected;
		this.testPrice = testPrice;
	}
	
	@Parameters
	public static Collection<Object[]> testConditions(){
		Object[][] testInput = {
				{"Next Day", "None", new String[] {"product 1"}, 85.00},
				{"Next Day", "None", new String[] {"product 2"}, 105.00},
				{"Next Day", "None", new String[] {"product 3"}, 155.00},
				{"Next Day", "None", new String[] {"product 1", "product 2"}, 185.00},
				{"Next Day", "None", new String[] {"product 2", "product 3"}, 255.00},
				{"Next Day", "None", new String[] {"product 1", "product 2", "product 3"}, 335.00},
				{"1st Class", "CODE1", new String[] {"product 1"}, 70.975},
				{"Standard", "CODE2", new String[] {"product 1", "product 2"}, 136.875},
				{"Next Day", "CODE1", new String[] {"product 1", "product 2", "product 3"}, 284.75},
				{"Standard", "CODE2", new String[] {"product 1", "product 2", "product 3"}, 249.375},
				{"1st Class", "CODE1", new String[] {"product 1", "product 3"}, 198.475},
				
		};
		return Arrays.asList(testInput);
	}

	@Before
	public void setup() {
		testOrder = new Order();
		testOrder.setDelivery(testDelivery);
		testOrder.setDiscountCode(testDiscountCode);
		testOrder.setSelected(testSelected);
	}
	
	@Test
	public void calculatePrice_p1_noDiscount() throws Exception{
		OrderController.calculatePrice(testOrder);
		// allowing a difference of 0.01 as currency is rounded to 2d.p.
		assertEquals(testPrice, testOrder.getPrice(), 0.01);
	}
	
	
	
	
}
