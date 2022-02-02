package d01_02_2022;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
//		Napisati program koji :
//			Ucitava stranicu https://www.udemy.com/courses/search/?src=ukw&q=slksd
//			Klikce na dugme za jezik i proverava da li se prikazuje dijalog za promenu jezika
//			Stampa u konzoli tekst “Dijalog se prikazao”

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.udemy.com/courses/search/?src=ukw&q=slksd");
		driver.findElement(By.xpath("//*[contains(@class,'language-selector-button--button--1wgoL')]")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'language-selector-modal-trigger--modal--3jcoz')]")));
		
		
		System.out.println("Prozor se pojavio");

	}

}
