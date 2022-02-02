package d01_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) {
//		2.Zadatak
//		Napisti program koji:
//		Ucitava stranicu https://videojs.com/city
//		Pusta video klikom na play dugme
//		Cekamo da se video ucita
//		Tako sto proveravamo da li vise to play dugme nije vidljivo

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://videojs.com/city");	
		driver.findElement(By.xpath("//*[@class='vjs-big-play-button']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='vjs-big-play-button']")));
		
		System.out.println("Dugme play nije vise vidljivo");


	}

}
