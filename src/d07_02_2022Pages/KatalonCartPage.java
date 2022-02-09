package d07_02_2022Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KatalonCartPage {
	private WebDriver driver;
	  
	  public KatalonCartPage(WebDriver driver) {
		  this.driver=driver;
	  }
	public List <WebElement> numberOfProducts() {
		
	List<WebElement> lista;
	return lista=driver.findElements(By.xpath("//*[contains(@class,'shop_table shop_table_responsive')]/tbody/tr[contains(@class,'cart_item')]"));
		
	}
	public String getQuantityInfo() {
		return driver.findElement(By.xpath("//*[@type='number']")).getAttribute("value");
	}
	  public WebElement getRemoveButton() {
		  return driver.findElement(By.className("remove"));
	  }
	  
	  public String getRemoveMessage() {
		  return driver.findElement(By.xpath("//*[@class='cart-empty woocommerce-info']")).getText();
	  }
}
