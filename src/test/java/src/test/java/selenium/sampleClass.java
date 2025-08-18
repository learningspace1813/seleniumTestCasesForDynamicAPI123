package src.test.java.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class sampleClass {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void testNavigateToAdminMenu() {
	        // Step 1: Go to OrangeHRM site
	        driver.get("https://opensource-demo.orangehrmlive.com/");

	        // Step 2: Login
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        // Step 3: Wait for Admin menu and click
	        WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']")));
	        adminMenu.click();

	        // Step 4: Verify Admin page loaded
	        //wait.until(ExpectedConditions.urlContains("/admin/viewAdminModule"));
	        //Assertions.assertTrue(driver.getCurrentUrl().contains("admin"), "Admin page did not load.");
	        //System.out.println("✅ Admin page loaded successfully.");
	        WebElement usermanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[contains(@class,'oxd-topbar-body-nav-tab')])[1]")));
	        usermanagement.click();
	        
	        System.out.println(usermanagement+"element got clicked!");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }


}
