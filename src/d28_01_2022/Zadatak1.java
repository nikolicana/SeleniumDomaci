package d28_01_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		//Zadatak 
				//Maksimizirati prozor
				//Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
				//Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
				//I izvrsite akciju klik na odgovarajuci element
				//Na kraju programa ugasite pretrazivac.
				System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				
				Scanner s=new Scanner(System.in);
				System.out.println("Unesite broj zvezdice na koju treba da se klikne: ");
				int zvezda= s.nextInt();
				driver.manage().window().maximize();
				
				driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
				Thread.sleep(2000);
				
				
				List <WebElement> zvezdice= driver.findElements(By.xpath("//*[@id='rating-ability-wrapper']//button"));
				
				for (int i=0;i<zvezdice.size();i++) {
					if (i+1== zvezda) {
						zvezdice.get(i).click();
					}
				}
				Thread.sleep(2000);
				driver.close();
			}

		}
