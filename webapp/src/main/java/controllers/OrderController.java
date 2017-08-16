package controllers;

import java.text.DecimalFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, ste);
		
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		Order theOrder = new Order();
		
		theModel.addAttribute("order", theOrder);
		
		
		return "order-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processOrderForm(@Valid @ModelAttribute("order") Order theOrder,
			BindingResult result) {
		
		System.out.println("inside the process order form");
		System.out.println("Binding Reuslt: " + result);
		
		if(result.hasErrors()) {
			System.out.println("inside the has errors method");
			return "order-form";
		} else {
			
			System.out.println("inside the else");
		
		// business logic: calculating the cost and applying discount
			calculatePrice(theOrder);
		// set invalid discount code to none
			if(theOrder.getDiscountCode()==null ||
					!(theOrder.getDiscountCode().equals("CODE1") || theOrder.getDiscountCode().equals("CODE2"))) {
				theOrder.setDiscountCode("None");
			}
				
		System.out.println("just before going to the order-confirmation");
		
		return "order-confirmation";
		
		}
	}
	
	public static void calculatePrice(Order theOrder) {
		double finalPrice= 0.0;
		for(String product: theOrder.getSelected()) {
			finalPrice += theOrder.getProducts().get(product);
		}
		finalPrice += theOrder.getDeliveries().get(theOrder.getDelivery());
		
		finalPrice *= 
				theOrder.getDiscounts().getOrDefault(theOrder.getDiscountCode(), 1.00);
		DecimalFormat df = new DecimalFormat("#.##");
		String stringFinalPrice = df.format(finalPrice);
		finalPrice = Double.parseDouble(stringFinalPrice);
		theOrder.setPrice(finalPrice);
	}

}
