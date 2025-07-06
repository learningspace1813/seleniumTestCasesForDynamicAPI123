package simpleSeleniumTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import orderMultipleAmznProducts.STP_01_variablesAmznProducts;
import orderMultipleAmznProducts.STP_02_baseTest;

public class TC_01_orderSingleProduct extends STP_02_baseTest{
    protected WebDriver driver;
    protected WebDriverWait wait;
    String url = "https://www.amazon.in/";
	//Home page verification
	public static final By homepageHeaderXpath = By.xpath("//a[@aria-label=\"Amazon.in\"]");
	public static final By NonShopingPageXpath = By.xpath("//h4['Click the button below to continue shopping']");
	
	public static final By continueShoppingXpath = By.xpath("//button[@type='submit']");
	public static final By productSelectionXpath = By.xpath("//h2[contains(@aria-label,'Iron Man 3D Night Light, XXMANX Baby Night Light with 7 Colors 16 Colors')]");
	public static final By quantity = By.xpath("//span[text()='Quantity:']");
	public static final By addToCart = By.xpath("//input[@id='add-to-cart-button']");

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
    
    @Test(priority=1, description="Homepage Verification.")
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
	public void searchProduct() {
		WebElement addProduct = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		addProduct.sendKeys("3D Illusion Iron Man534" + Keys.ENTER);
	}
	
	@Test(priority=3, description = "ordering 3D Illusion Iron Man534.")
	public void selectProduct() {
		WebElement slctProduct = driver.findElement(productSelectionXpath);
		slctProduct.click();
		
		//Select Quantity through dropdown
//        WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-0-announce")));
//        //userDropdown.click();
//        Select select = new Select(userDropdown);
        // 3) Use one of these methods to select an option:
//        select.selectByVisibleText("1");         // Selects the option displaying text "1" or If your html is like that "<option value="1">1</option>"
//        select.selectByValue("1");               // Selects the option with value="1"
//        select.selectByIndex(0);                 // Selects the second option (index starts at 0)
        
//      // Get the currently selected option
//        WebElement selectedOption = select.getFirstSelectedOption();
//        System.out.println("Currently selected: " + selectedOption.getText());
//
//        // Get all options in the dropdown
//        for (WebElement option : select.getOptions()) {
//            System.out.println("Option: " + option.getText());
//        }

        WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-0-announce")));
        userDropdown.click();
        WebElement clrAndSelectOne = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-labelledby='quantity_0']")));
        clrAndSelectOne.click();
		
		//Confirm Quantity is exactly one
//		WebElement productQuantity = driver.findElement(quantity);
//		productQuantity.click();
		
		//Add product to cart
		WebElement addProductToCart = driver.findElement(addToCart);
		addProductToCart.click();
	}
	
	
	
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}