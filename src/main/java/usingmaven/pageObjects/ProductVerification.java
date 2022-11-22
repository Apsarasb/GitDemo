package usingmaven.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class ProductVerification extends AbstractClassComponents {

	WebDriver driver;

	public ProductVerification(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".cartSection h3")
	List<WebElement> prod;

	@FindBy(css = ".totalRow button")
	WebElement Checkout;

	public Payment verifyProduct(String prodlist) {
		ProductVerification verify = new ProductVerification(driver);
		for (int i = 0; i < prod.size(); i++) {
			String product = prod.get(i).getText();
			if (product.equalsIgnoreCase(prodlist)) {
				System.out.println("matches");
			} else {
				System.out.println("not matching");
			}
		}
		Checkout.click();
		Payment pay =new Payment(driver);
		return pay;
		
	}

}
