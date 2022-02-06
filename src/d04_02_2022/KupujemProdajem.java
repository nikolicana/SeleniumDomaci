package d04_02_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KupujemProdajem {

//	Umesto prvog za Udemy imamo kupujem prodajem.
//	Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace)
//	Ukucajte za pretragu iphone
//	postavice za valutu eure
//	Sortirajte prema ceni da bude najjefinije prvo
//	Onda izvrsite proveru sortiranja kao sto je bilo za udemy
	
	
	WebDriver driver;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void sortiranje() throws InterruptedException {
		driver.navigate().to("https://www.kupujemprodajem.com/");
		driver.findElement(By.className("kpBoxCloseButton")).click();
		driver.findElement(By.id("searchKeywordsInput")).sendKeys("Iphone");
		Thread.sleep(2000);
		driver.findElement(By.id("searchKeywordsInput")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("priceSecondSelection")).click();
		driver.findElement(By.xpath("//input[@value='eur']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='priceSelection']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='searchButton secondarySearchButton']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='orderSecondSelection']//div[@class='choiceLabel']")).click();
		// driver.findElement(By.xpath("//*[@id='orderSecondSelection']/div/div/div/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@data-value='price']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='searchButton secondarySearchButton']")).click();
		// provera sortiranja

		List<WebElement> a = driver.findElements(By.xpath("//*[@class='adPrice ']"));

		//System.out.println(a.get(0).getText());
		//System.out.println(a.get(a.size() - 1).getText());

		String s = a.get(0).getText();
		String s1 = a.get(a.size() - 1).getText();
		String newS = s.replaceAll("din", " ");
		System.out.println(newS);
		Double d = Double.parseDouble(newS);
		System.out.println(d);
		String newS1 = s1.replaceAll("din", " ");
		Double d1 = Double.parseDouble(newS1);

		Assert.assertTrue(d < d1, "Cene nisu poredjane po opadajucem redosledu");
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}

