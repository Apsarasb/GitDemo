package usingmaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) {
		String prodlist = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.rahulshettyacademy.com/client/");
		driver.manage().window().maximize();

		driver.findElement(By.id("userEmail")).sendKeys("apsara@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Apsara@123");
		driver.findElement(By.id("login")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".mb-3  b"));
		for (int i = 0; i < list.size(); i++) {
			String name = driver.findElements(By.cssSelector(".mb-3  b")).get(i).getText();
			System.out.println(driver.findElements(By.cssSelector(".mb-3  b")).get(i).getText());
			if (name.equals("ADIDAS ORIGINAL")) {
				driver.findElements(By.cssSelector(".btn.w-10")).get(i).click();
				System.out.println("added to cart");
				break;
			}

		}

		// cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		// verify
		List<WebElement> prod = driver.findElements(By.cssSelector(".cartSection h3"));
		for (int i = 0; i < prod.size(); i++) {
			String product = driver.findElements(By.cssSelector(".cartSection h3")).get(i).getText();
			if (product.equalsIgnoreCase(prodlist)) {
				System.out.println("matches");
			} else {
				System.out.println("not matching");
			}
		}
		driver.findElement(By.cssSelector(".totalRow button")).click();

		// payment
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("India");
		// (//button[contains(@class,'ta-item')])[2]
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String message= driver.findElement(By.cssSelector(".box h1")).getText();
		System.out.println(message);
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
