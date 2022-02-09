package d07_02_2022Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KatalonWantedProductPage {

	private WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public KatalonWantedProductPage(WebDriver driver) {
		  this.driver=driver;
	  }

	
	public WebElement getInputQuantity() {
	return	driver.findElement(By.xpath("//div[@class='quantity']/input"));
	}
	
	public void clearInsertInputQuantity(String broj) {
		getInputQuantity().click();
		getInputQuantity().clear();
		getInputQuantity().sendKeys(broj);
	}
	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//*[@class='single_add_to_cart_button button alt']"));
	}
	  public String getMessage() {
		  return driver.findElement(By.xpath("//*[@role='alert']")).getText();
	  }
	  
	  public WebElement getViewCartButton() {
		  return driver.findElement(By.xpath("//*[@class='button wc-forward']"));
	  }
}
