package d07_02_2022Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d07_02_2022Pages.FormPage;
import d07_02_2022Pages.KatalonCartPage;
import d07_02_2022Pages.KatalonHomePage;
import d07_02_2022Pages.KatalonShopPage;
import d07_02_2022Pages.KatalonWantedProductPage;

public class KatalonTest {
	private WebDriver driver;
    private KatalonCartPage cp;
    private KatalonHomePage hp;
    private KatalonShopPage sp;
    private KatalonWantedProductPage wpp;
    
	
	
	
	@BeforeMethod
	
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		cp = new KatalonCartPage(driver);
		hp = new KatalonHomePage(driver);
		sp = new KatalonShopPage(driver);
		wpp = new KatalonWantedProductPage(driver);
		
	}		
	@Test
	public void AddRemoveProductsCart() throws InterruptedException {
		driver.get("http://cms.demo.katalon.com/");
		Thread.sleep(1000);
		hp.getShopButton().click();
		//sp.getFirstProduct();
		sp.getProduct(0).click();
		wpp.clearInsertInputQuantity("2");
		wpp.getAddToCart().click();
		Thread.sleep(1000);
		Assert.assertTrue(wpp.getMessage().contains("have been added to your cart"), "Nije dodat trazeni proizvod");
		wpp.getViewCartButton().click();
		Thread.sleep(1000);
		Assert.assertEquals(cp.numberOfProducts().size(), 1);
		Assert.assertEquals(cp.getQuantityInfo(), "2", "Ne sadrzi odgovarajuci broj proizvoda");
		cp.getRemoveButton().click();
		Thread.sleep(1000);
		Assert.assertEquals(cp.getRemoveMessage(), "Your cart is currently empty.", "Korpa nije prazna");
	}	
		@AfterMethod
		public void closeAll() {
			driver.quit();
		}
}
