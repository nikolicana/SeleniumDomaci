package d07_02_2022Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KatalonHomePage {
	private WebDriver driver;
	  
	  public KatalonHomePage(WebDriver driver) {
		  this.driver=driver;
	  }
	  
	  public WebElement getShopButton() {
		  return driver.findElement(By.xpath("//li[@class='page_item page-item-7 current_page_item']"));
	  }
}
