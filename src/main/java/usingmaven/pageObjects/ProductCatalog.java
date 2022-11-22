package usingmaven.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class ProductCatalog extends AbstractClassComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".mb-3  b")
	List<WebElement> list;

	@FindBy(css = "btn.w-10")
	List<WebElement> addCart;

	@FindBy(css = ".btn.w-10")
	List<WebElement> button;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartbuton;
	

	By toastmessage = By.id("toast-container");
	By loader =By.cssSelector(".ng-animating");
	By clickable1 = By.xpath("//button[@routerlink='/dashboard/cart']");
	
	
	public List<WebElement> getProductList() {

		return list;
	}

	public ProductVerification AddtoCart(String prodlist) {
	
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).getText();
			if (name.equals(prodlist)) {
				button.get(i).click();
			}
		}
		waitForElementToDisappear(loader);
		//waitForElementToAppear(toastmessage);
		
		waitForElementToBeClickable(cartbuton);
		cartbuton.click();
		ProductVerification verify = new ProductVerification(driver);
		return verify;
	}
	
}
