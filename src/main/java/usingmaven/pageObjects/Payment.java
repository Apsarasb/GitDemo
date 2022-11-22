package usingmaven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class Payment extends AbstractClassComponents {

	WebDriver driver;

	public Payment(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".form-group input")
	WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement dropdown;
	// .action__submit

	@FindBy(css = ".action__submit")
	WebElement placeorder;
//
	@FindBy(css = ".box h1")
	WebElement message;
//

//	By toastmessage = By.id("toast-container");
//	By loader = By.cssSelector(".ng-animating");
//	By clickable1 = By.xpath("//button[@routerlink='/dashboard/cart']");

	public ConfirmationPage cartPayment() {
		country.sendKeys("India");
		dropdown.click();
		placeorder.click();
		ConfirmationPage confirm = new ConfirmationPage(driver);
		return confirm;

	}

}
