package usingmaven.abstractClassComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import usingmaven.pageObjects.OrderHeaderPage;

public class AbstractClassComponents {
	WebDriver driver;
	public AbstractClassComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement OrderHeader;
	
	@FindBy(xpath = "//th[text()='Name']")
	WebElement myorder;
	
	
	public OrderHeaderPage goToOrders() {
		OrderHeader.click();
		//waitForWebElementToAppear(myorder);
		waitForWebElementtoAppear(myorder);
		OrderHeaderPage order = new OrderHeaderPage(driver);
		return order;
	}
	

	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementtoAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		}
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
}
