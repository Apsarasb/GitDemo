package usingmaven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import usingmaven.TestComponents.BaseTest;
import usingmaven.pageObjects.Payment;
import usingmaven.pageObjects.ProductCatalog;
import usingmaven.pageObjects.ProductVerification;

public class ErrorValidations extends BaseTest {
	@Test(groups= {"testerror"})
	public void validation() {

		// LandingPage landing =launchApplication();
		ProductCatalog catalogs = landing.loginApplication("apsara@gmail.com", "Apjkek@123");
		String error = landing.errorValidate();
		System.out.println(error);
		Assert.assertEquals("Incorrect email or password.", error);

	}

	@Test
	public void productValidation() {
		String prodlist = "ADIDAS ORIGINAL";

		// LandingPage landing =launchApplication(); 
		ProductCatalog catalogs = landing.loginApplication("apsara@gmail.com", "Apsara@123");
		// ProductCatalog catalogs = new ProductCatalog(driver);
		List<WebElement> list = catalogs.getProductList();
		System.out.println("works till here");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ProductVerification verify = catalogs.AddtoCart(prodlist);
		// ProductVerification verify = new ProductVerification(driver);
		System.out.println("works second");
		Payment pay = verify.verifyProduct("adidas hkl");
	}
}
