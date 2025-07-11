package simpleSeleniumTestCases;

import orderMultipleAmznProducts.STP_01_variablesAmznProducts;
import orderMultipleAmznProducts.STP_02_baseTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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
	public static final By productSelection1Xpath = By.xpath("//h2[contains(@aria-label,'Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors')]");
	public static final By productSelection2Xpath = By.xpath("(//div[@data-cy='title-recipe']//span['Samsung Galaxy S24 FE 5G AI Smartphone (Graphite, 8GB RAM, 128GB Storage)'])[3]");

	public static final By sortBy = By.xpath("//span[@class='a-button-inner']//span[@data-action='a-dropdown-button']");
	public static final By sortByLtoH = By.xpath("//li[@aria-labelledby='s-result-sort-select_1']");
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
	public void browserProduct1() throws InterruptedException {
		//------------------------------------------------------------
		//Search Product
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors" + Keys.ENTER);		
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		WebElement slctProduct = driver.findElement(productSelection1Xpath);
		slctProduct.click();
		
		//------------------------------------------------------------
		//Select Quantity
		WebElement productQuantity = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]"));
		productQuantity.click();
		
		WebElement selectQuantity = driver.findElement(By.xpath("(//a[@id='quantity_0'])[1]"));
		selectQuantity.click();
		
		//------------------------------------------------------------
		//Add to bucket
		WebElement aadProductInProduct = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		aadProductInProduct.click();
		
		System.out.println("Product1 ordered successfully!");
	}
	
	@Test(priority=2, description = "Order 2nd product - Samsung Galaxy S24(gray)")
	public void browserProduct2() throws InterruptedException {
		//------------------------------------------------------------
		//Search Product2
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("Samsung Galaxy S24 Ultra 5G AI Smartphone" + Keys.ENTER);		
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
				
		//-----------------------------------------------------------
		//Sort By Low to High/high to Low
		WebElement sortByDrpDwn = driver.findElement(sortBy);
		sortByDrpDwn.click();
		
		WebElement sortByValue = driver.findElement(sortByLtoH);
		sortByValue.click();
		
		//confirm product
		WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(productSelection2Xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", productElement);
		wait.until(ExpectedConditions.visibilityOf(productElement));
		productElement.click();
		
//		WebElement slctProduct = driver.findElement(productSelection2Xpath);
//		slctProduct.click();
		
		//------------------------------------------------------------
		//Select Quantity
		WebElement productQuantity = driver.findElement(By.xpath("//span[@id='a-autoid-4']"));
		productQuantity.click();
		
		WebElement selectQuantity = driver.findElement(By.xpath("(//a[@id='quantity_0'])[1]"));
		selectQuantity.click();
		
		//------------------------------------------------------------
		//Add to bucket
		WebElement aadProductInProduct = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		aadProductInProduct.click();
		
		System.out.println("Product1 ordered successfully!");
	}
	
//	@Test(priority=3, description = "Select product Quantity.")
//	public void quantity() {
//		// TODO Auto-generated method stub
//		WebElement productQuantity = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]"));
//		productQuantity.click();
//		
//		WebElement selectQuantity = driver.findElement(By.xpath("(//a[@id='quantity_0'])[1]"));
//		selectQuantity.click();
//	}
//	
//	@Test(priority=4, description = "Select product Quantity.")
//	public void addToBucket() {
//		WebElement aadProductInProduct = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
//		aadProductInProduct.click();
//	}
	
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
