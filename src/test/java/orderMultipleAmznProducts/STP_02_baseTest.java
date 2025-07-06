package orderMultipleAmznProducts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class STP_02_baseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    String url = "https://www.amazon.in/";

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    
    @Test(description="Homepage Verification.")
	public void verifyHomepage() {
		if (!driver.findElements(STP_01_variablesAmznProducts.NonShopingPageXpath).isEmpty()) {
			WebElement ContinueShopping = driver.findElement(STP_01_variablesAmznProducts.continueShoppingXpath);
			ContinueShopping.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(STP_01_variablesAmznProducts.homepageHeaderXpath));
		} else if (!driver.findElements(STP_01_variablesAmznProducts.homepageHeaderXpath).isEmpty()) {			
			System.out.println("Main UI detected. Proceeding...");
		} else {
			System.out.println("Main UI detected. Proceeding...");
		}	
	}

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
