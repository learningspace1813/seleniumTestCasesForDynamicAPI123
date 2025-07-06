package simpleSeleniumTestCases;

import orderMultipleAmznProducts.STP_01_variablesAmznProducts;
import orderMultipleAmznProducts.STP_02_baseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02_orderMtplAmznProducts extends STP_02_baseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    String url = "https://www.amazon.in/";
	public static final By homepageHeaderXpath = By.xpath("//a[@aria-label=\"Amazon.in\"]");
	public static final By NonShopingPageXpath = By.xpath("//h4['Click the button below to continue shopping']");
	
	public static final By continueShoppingXpath = By.xpath("//button[@type='submit']");
	public static final By productSelectionXpath = By.xpath("//h2[contains(@aria-label,'Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors')]");

	public static final String PeacockFeatherWL = "Lamp master 3-in-1 LED Peacock Feather Wall Light | Creative Acrylic Decorative Wall Lamp";
	public static final By PeacockFeatherWLXpath = By.xpath("//.[contains(text(),'Lamp master 3-in-1 LED Peacock Feather Wall Light | Creative Acrylic Decorative Wall Lamp')]");
	
	

	
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

	@Test(priority=1, description = "Homepage Verification.")
	public void verifyHomepage() {
		if (!driver.findElements(NonShopingPageXpath).isEmpty()) {
			WebElement ContinueShopping = driver.findElement(continueShoppingXpath);
			ContinueShopping.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(homepageHeaderXpath));
		} else if (!driver.findElements(homepageHeaderXpath).isEmpty()) {			
			System.out.println("Main UI detected. Proceeding...");
		} else {
			System.out.println("Main UI detected. Proceeding...");
		}	
	}
	
	@Test(priority=2, description = "Searching my product.")
	public void browserProduct() throws InterruptedException {
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors" + Keys.ENTER);		
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		WebElement slctProduct = driver.findElement(productSelectionXpath);
		slctProduct.click();
	}
	
	@Test(priority=3, description = "Select product Quantity.")
	public void quantity() {
		// TODO Auto-generated method stub
		WebElement productQuantity = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]"));
		productQuantity.click();
		
		WebElement selectQuantity = driver.findElement(By.xpath("(//a[@id='quantity_0'])[1]"));
		selectQuantity.click();
	}
	
	@Test(priority=4, description = "Select product Quantity.")
	public void addToBucket() {
		WebElement aadProductInProduct = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		aadProductInProduct.click();
	}
	
        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
