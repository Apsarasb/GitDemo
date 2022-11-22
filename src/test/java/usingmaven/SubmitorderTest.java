package usingmaven;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import usingmaven.TestComponents.BaseTest;
import usingmaven.pageObjects.ConfirmationPage;
import usingmaven.pageObjects.OrderHeaderPage;
import usingmaven.pageObjects.Payment;
import usingmaven.pageObjects.ProductCatalog;
import usingmaven.pageObjects.ProductVerification;

public class SubmitorderTest extends BaseTest {
	String prodlist = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException {
		// String prodlist = "ADIDAS ORIGINAL";

		// LandingPage landing =launchApplication();
		ProductCatalog catalogs = landing.loginApplication(input.get("email"), input.get("password"));
		// ProductCatalog catalogs = new ProductCatalog(driver);
		List<WebElement> list = catalogs.getProductList();
		System.out.println("submit order");
		ProductVerification verify = catalogs.AddtoCart(input.get("product"));
		// ProductVerification verify = new ProductVerification(driver);
		Payment pay = verify.verifyProduct(input.get("product"));
		// =new Payment(driver);
		ConfirmationPage confirm = pay.cartPayment();
		// ConfirmationPage confirm = new ConfirmationPage(driver);
		String msg = confirm.getConfirmation();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		// driver.close();
	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void verifyOrder() throws InterruptedException {
		ProductCatalog catalogs = landing.loginApplication("apsara@gmail.com", "Apsara@123");
		OrderHeaderPage ord = catalogs.goToOrders();
		// ord.viewOrderDisplay(prodlist);
		Assert.assertTrue(ord.viewOrderDisplayusingStream(prodlist));
	}

	
	
	// ----------------using jsonto string to hashmap---------------
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonToMap(
				System.getProperty("user.dir" )+ "//src//test//java//usingmaven//data//readerfiletest.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	

	
	
	
	
//-----------------------------Using Data provider------------------------

	// @Test(dataProvider = "getData", groups = { "Purchase" })
//	public void SubmitOrder(HashMap<String,String> input) throws IOException {
//		// String prodlist = "ADIDAS ORIGINAL";
//
//		
//		ProductCatalog catalogs = landing.loginApplication(email), input.get("password"));		
//		List<WebElement> list = catalogs.getProductList();
//		ProductVerification verify = catalogs.AddtoCart(input.get("product"));	
//		Payment pay = verify.verifyProduct(input.get("product"));		
//		ConfirmationPage confirm = pay.cartPayment();
//		String msg = confirm.getConfirmation();
//		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//
//	}
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "richu@gmail.com", "Richu@123", "ZARA COAT 3" },
//				{ "praveen@gmail.com", "Praveen@123", "IPHONE 13 PRO" } };
//	}

	// -----------------------Using Hashmap------------------------------------

//	@Test(dataProvider = "getData", groups = { "Purchase" })
//	public void SubmitOrder(HashMap<String,String> input) throws IOException {
//		// String prodlist = "ADIDAS ORIGINAL";
//
//		// LandingPage landing =launchApplication();
//		ProductCatalog catalogs = landing.loginApplication(input.get("email"), input.get("password"));
//		// ProductCatalog catalogs = new ProductCatalog(driver);
//		List<WebElement> list = catalogs.getProductList();
//		ProductVerification verify = catalogs.AddtoCart(input.get("product"));
//		// ProductVerification verify = new ProductVerification(driver);
//		Payment pay = verify.verifyProduct(input.get("product"));
//		// =new Payment(driver);
//		ConfirmationPage confirm = pay.cartPayment();
//		// ConfirmationPage confirm = new ConfirmationPage(driver);
//		String msg = confirm.getConfirmation();
//		AssertJUnit.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		// driver.close();
//	}
	// @DataProvider
//	public Object[][] getData() {
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "richu@gmail.com");
//		map.put("password", "Richu@123");
//		map.put("product", "ZARA COAT 3");
//		return new Object[][]{{map}};
//	}

}
