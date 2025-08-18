package src.test.java.selenium;

import java.util.List;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class allFunctionalities {
	WebDriver d;
	WebDriverWait wait;
	//String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		Thread.sleep(2000);
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("URL working properly...");
		wait = new WebDriverWait(d, Duration.ofSeconds(10));
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=1)
	public void functionalities() throws InterruptedException {
		WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));

		username.sendKeys("Admin");
		System.out.println("username updated...");
		
		WebElement password = d.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("admin123");
		
		WebElement login = d.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		System.out.println("Login successfull....");
		
        WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
        adminMenu.click();
	}
	
//	@Test(priority=2, dependsOnMethods = {"functionalities"})
//	public void AdminSection() throws InterruptedException {
//		Thread.sleep(3000);
//        // Step 3: Wait for Admin menu and click
//        WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
//        adminMenu.click();
//
//		WebElement usermanagement = d.findElement(By.xpath(resource.userMngmntDD));
//		usermanagement.click();
//		
//		List<WebElement> configOptions = d.findElements(By.xpath(resource.moreMenu));
//		//List<WebElement> ConfigDDItems = (List<WebElement>) d.findElement(By.xpath(resource.moreMenu));
//		
//		for (WebElement item : configOptions) {
//			System.out.println("List Items: "+ item.getText());
//		}
//	}
	
	@Test(priority=2, dependsOnMethods = {"functionalities"})
	public void AdminSection() throws InterruptedException {
	    System.out.println("Starting AdminSection test...");

	    Thread.sleep(3000); // try to reduce or remove later
	    System.out.println("Looking for Admin menu...");
	    
	    WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
	    System.out.println("Admin menu found, clicking...");
	    adminMenu.click();

	    System.out.println("Looking for User Management...");
	    WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(resource.userMngmntDD)));
	    usermanagement.click();
	    System.out.println("User Management clicked.");

	    List<WebElement> configOptions = d.findElements(By.xpath(resource.moreMenu));
	    System.out.println("Found " + configOptions.size() + " config options.");

	    for (WebElement item : configOptions) {
	        System.out.println("List Item: " + item.getText());
	    }
	}
}
