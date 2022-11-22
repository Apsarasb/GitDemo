package usingmaven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class LandingPage extends AbstractClassComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement usernameEle;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = ".toast-error")
	WebElement errorMessage;
	
	public ProductCatalog loginApplication(String username, String password) {
		usernameEle.sendKeys(username);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog catalogs = new ProductCatalog(driver);
		return catalogs;
	}
	public void goTo() {
		driver.get("http://www.rahulshettyacademy.com/client/");
	}
	public String errorValidate() {
		waitForWebElementtoAppear(errorMessage);
		return errorMessage.getText();
	}


}
