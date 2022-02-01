package d28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
//		/Zadatak
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati red podataka - jedan red u jednoj iteraciji 
//		Kliknite na dugme Add New
//		Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//		Kliknite na zeleno Add dugme
//		Na kraju programa ugasite pretrazivac.
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
		Scanner s=new Scanner(System.in);
		driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		
		
		for(int i=0;i<4;i++) {
			System.out.println("Unesi ime: ");
			driver.findElement(By.xpath("//*[@class='btn btn-info add-new']")).click();
			String ime= s.next();
			driver.findElement(By.xpath("//*[@id='name'][last()]")).sendKeys(ime);
			System.out.println("Unesi departman: ");
			String departman=s.next();
			driver.findElement(By.xpath("//*[@id='department'][last()]")).sendKeys(departman);
			System.out.println("Unesi departman: ");
			String telefon=s.next();
			driver.findElement(By.xpath("//*[@id='phone'][last()]")).sendKeys(telefon);
		    driver.findElement(By.xpath("//tr[last()]//a[@class='add']")).click();
		    
		}
		
		driver.close();
		

	}

}
	

	
