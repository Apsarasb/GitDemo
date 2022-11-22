package usingmaven.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import usingmaven.abstractClassComponents.AbstractClassComponents;

public class ConfirmationPage extends AbstractClassComponents{

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));
	@FindBy(css = ".box h1")
	WebElement confirmationMessage;

	public String getConfirmation() {
		System.out.println(confirmationMessage.getText());
		return confirmationMessage.getText();
	}

}
