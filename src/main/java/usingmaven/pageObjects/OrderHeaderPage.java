package usingmaven.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class OrderHeaderPage extends AbstractClassComponents {
	WebDriver driver;

	@FindBy(xpath = "//td[position()=2]")
	List<WebElement> ordername;

	public OrderHeaderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public Boolean viewOrderDisplayusingStream(String prodlist) {
		
		
		Boolean match =ordername.stream().anyMatch(product -> product.getText().equalsIgnoreCase(prodlist));
System.out.println("again");	
return match;
	}

	public boolean viewOrderDisplay(String prodlist) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(ordername.size());
		for (int i = 0; i < ordername.size(); i++) {
			String product = ordername.get(i).getText();
			System.out.println(ordername.get(i).getText());
			if(product.equalsIgnoreCase(prodlist)) {
				return true;
			}
	}return false;
}}
