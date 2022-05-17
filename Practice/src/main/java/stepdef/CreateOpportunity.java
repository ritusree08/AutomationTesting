package stepdef;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity {
	
	public ChromeDriver driver;
    
	
	@Given("Open the chrome Browser")
	public void opening_chrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);//opening chrome browser

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
	}
	
	@When("go to global icon and select Create Opportunity")
	public void global_icon() {
		
	driver.findElement(By.xpath("//ul[@class='slds-global-actions']//child::li[3]")).click();
			driver.findElement(By.xpath("//ul[@class='scrollable']//child::li[5]")).click();// clicking on global icon and selecting new opportunity
	}

	@Then("Enter new opportunity name")
	public void opportunity_name() {
		driver.findElement(By.xpath("//input[@maxlength='120']")).sendKeys("xyz1");//giving input to opportunity name

	}
	
	@And("Select account name")
	public void account_name() {
		driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).click();
		driver.findElement(By.xpath("//div[@title='RAm']")).click();//selecting account name
	}
	
	@And("Select stage")
	public void select_stage() {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//div[@class='select-options']//ul[@role='presentation']//child::li[4]")).click();//selecting stage
	}
	
	@And("select amount")
	public void amount() {
		driver.findElement(By.xpath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']")).sendKeys("123");//putting amount

	}
    
	@When("click on save")
	public void saving() {
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']")).click();//saving the opportunity

	}



}
