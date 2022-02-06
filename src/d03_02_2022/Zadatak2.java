package d03_02_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {

//2.Zadatak
//Napisati program koji:
//Ucitava stanicu https://www.wikipedia.org/
//Sa stranice sakuplja sve linkove (jezike) i svaki link otvara u novom prozoru pretrazivaca
//Svaki link potrebno je otvoriti u novom tabu.
//Skripta: window.open(arguments[0]);
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(3000);
		
	List <WebElement> e=driver.findElements(By.xpath("//*[contains(@class,'central-featured')]/div/a"));
	for(int i=0;i<e.size();i++) {
	js.executeScript("window.open(arguments[0]);", e.get(i));

		
	}	
		
	}

}
