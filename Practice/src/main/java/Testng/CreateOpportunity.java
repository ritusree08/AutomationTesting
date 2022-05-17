package Testng;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {

	@Test
	
	public void CreateOpportunityPositive() {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);//opening chrome browser


		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Tuna@123");
		driver.findElement(By.id("Login")).click(); //login to salesforce application
		
		
		
		
		try {
			TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}


			driver.findElement(By.xpath("//ul[@class='slds-global-actions']//child::li[3]")).click();
			driver.findElement(By.xpath("//ul[@class='scrollable']//child::li[5]")).click();// clicking on global icon and selecting new opportunity
			
			
			
			driver.findElement(By.xpath("//input[@maxlength='120']")).sendKeys("xyz1");//giving input to opportunity name

			driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
			driver.findElement(By.xpath("//div[@title='RAm']")).click();//selecting account name

			driver.findElement(By.xpath("//a[@class='select']")).click();
			driver.findElement(By.xpath("//div[@class='select-options']//ul[@role='presentation']//child::li[4]")).click();//selecting stage
			
			driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']")).sendKeys("123");//putting amount
			
			driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();//saving the opportunity


	}

}
