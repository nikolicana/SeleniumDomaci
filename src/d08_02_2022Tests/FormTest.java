package d08_02_2022Tests;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.concurrent.TimeUnit;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d08_02_2022Pages.FormPage;

//Zatim kreirati FormTest koji 
//Ucitava form.html stranicu (form.html je u folderu za domaci skinite je i otvorite u chrome i iskopirajte url)
//I popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
//Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u formu nakon submitovanja


public class FormTest {

	private WebDriver driver;
    private FormPage fp;
    
	@BeforeMethod
	
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		fp = new FormPage(driver);
		
		
	}		

	@Test
	public void FillTheForm() throws InterruptedException, IOException {
		driver.get("file:///C:/Users/Korisnik/Downloads/form%20(1).html");
		Thread.sleep(500);
		File file = new File("Files/FormData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		SoftAssert sf=new SoftAssert();

		XSSFSheet sheet = wb.getSheet("form");
		for (int i = 1; i <=6; i++) {

			String fullName = sheet.getRow(i).getCell(0).getStringCellValue();
			String gender = sheet.getRow(i).getCell(1).getStringCellValue();

			// nasla sam kako se koristi format i clasa DateFormat

			Date dateOfBirth = sheet.getRow(i).getCell(2).getDateCellValue();
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			String role = sheet.getRow(i).getCell(4).getStringCellValue();
			String waysOfDev = sheet.getRow(i).getCell(5).getStringCellValue();
			String comment = sheet.getRow(i).getCell(6).getStringCellValue();
			
			
			
			fp.getFullName().sendKeys(fullName);
			Thread.sleep(500);
			fp.getGenderRadioButton(gender).click();
			Thread.sleep(500);
			// pretvaram format date u string da bi islo u send.keys ali dodaje i vreme, istrazicu jos
			
			DateFormat df = new SimpleDateFormat();
			String dateOfBirth1 = df.format(dateOfBirth);

			fp.getDateOfBirth().sendKeys(dateOfBirth1);
			fp.getEmail().sendKeys(email);
			Thread.sleep(500);
			fp.getRole().selectByValue(role);
			Thread.sleep(500);
			fp.getCheckbox(waysOfDev).click();
			Thread.sleep(500);
			fp.getComment().sendKeys(comment);
			Thread.sleep(500);
			fp.getSubmitButton().click();

			sf.assertTrue(fp.savedSuccesfully(),  "Forma nije uspesno snimljena");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(
					By.xpath("//*[@class='message-element poruka']"), "Uspesno ste sacuvali podatke!"));

			

	       //	Assert.assertTrue(fp.savedSuccesfully(), "Forma nije uspesno snimljena");
			
			driver.navigate().refresh();

		}
		
		sf.assertAll();
	}
	

	@AfterMethod
	public void after() {
		driver.quit();
	}
}
